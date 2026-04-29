package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class SpecController {
    
    private List<Item> items = new ArrayList<>();
    
    // Construtor com dados mockados
    public SpecController() {
        items.add(new Item("001", "Notebook Dell", "Notebook para desenvolvimento"));
        items.add(new Item("002", "Mouse Logitech", "Mouse sem fio"));
        items.add(new Item("003", "Teclado Mecânico", "Teclado RGB"));
    }
    
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(items);
    }
    
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        // Validação: id obrigatório
        if (item.getId() == null) {
            return ResponseEntity.badRequest()
                .body("Campo 'id' é obrigatório");
        }
        
        // Validação: nome obrigatório e não vazio
        if (item.getNome() == null || item.getNome().isBlank()) {
            return ResponseEntity.badRequest()
                .body("Campo 'nome' é obrigatório e não pode ser vazio");
        }
        
        // Validação: descrição obrigatória e não vazia
        if (item.getDescricao() == null || item.getDescricao().isBlank()) {
            return ResponseEntity.badRequest()
                .body("Campo 'descrição' é obrigatório e não pode ser vazio");
        }
        
        // Validação: ID único
        if (items.stream().anyMatch(i -> i.getId().equals(item.getId()))) {
            return ResponseEntity.badRequest()
                .body("Item com id '" + item.getId() + "' já existe");
        }
        
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String id) {
        boolean removed = items.removeIf(item -> item.getId().equals(id));
        
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Item com id '" + id + "' não encontrado");
    }
    
}
