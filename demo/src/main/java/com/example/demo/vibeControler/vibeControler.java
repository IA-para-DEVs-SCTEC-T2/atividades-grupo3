package com.example.demo.vibeControler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller REST para gerenciar items em memória.
 * Endpoints disponíveis: GET /items, POST /items, DELETE /items/{id}
 */
@RestController
@RequestMapping("/items")
public class vibeControler {

    // Array em memória para armazenar os items
    private final List<Map<String, Object>> items = new ArrayList<>();

    /**
     * GET /items
     * Retorna todos os items armazenados em memória.
     */
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getItems() {
        return ResponseEntity.ok(items);
    }

    /**
     * POST /items
     * Recebe um JSON com "id" e "nome", valida os campos e salva no array.
     * Retorna 201 com o item criado ou 400 em caso de erro de validação.
     */
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Map<String, Object> body) {

        // Validação: campo "id" é obrigatório
        if (!body.containsKey("id") || body.get("id") == null) {
            return ResponseEntity.badRequest().body("Campo 'id' é obrigatório.");
        }

        // Validação: campo "nome" é obrigatório e não pode ser vazio
        if (!body.containsKey("nome") || body.get("nome") == null
                || body.get("nome").toString().isBlank()) {
            return ResponseEntity.badRequest().body("Campo 'nome' é obrigatório e não pode ser vazio.");
        }

        Object novoId = body.get("id");

        // Validação: verifica se o id já existe no array
        boolean idExistente = items.stream()
                .anyMatch(item -> item.get("id").toString().equals(novoId.toString()));

        if (idExistente) {
            return ResponseEntity.badRequest().body("Item com id '" + novoId + "' já existe.");
        }

        // Salva apenas os campos esperados
        Map<String, Object> novoItem = Map.of(
                "id", novoId,
                "nome", body.get("nome")
        );

        items.add(novoItem);

        // Retorna 201 Created com o item criado
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    /**
     * DELETE /items/{id}
     * Remove o item pelo id informado na URL.
     * Retorna 204 se removido ou 404 se não encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String id) {

        // Busca o item pelo id
        boolean removido = items.removeIf(item -> item.get("id").toString().equals(id));

        if (!removido) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item com id '" + id + "' não encontrado.");
        }

        // Retorna 204 No Content após remoção bem-sucedida
        return ResponseEntity.noContent().build();
    }
}
