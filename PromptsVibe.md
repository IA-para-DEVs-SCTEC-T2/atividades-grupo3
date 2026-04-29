# Prompts Vibe

## Prompt 1

Contexto:
Desenvolva uma APi REST em java com springboot. O objetivo é criar um projeto backend para gerenciar items em memória que permite listar, adicionar e remover os items via endpoint http.

Constraints:
- utilize apenas java e springboot
- os dados devem ficar armazenados em memoria em array chamado items.
- organize o codigo de forma limpa e legivel.
- o nome da classe será vibeControler
- crie dentro de demo\src\main\java\com\example\demo\vibeControler
- adicione comentarios explicando as principais partes do código

Tipo:
crie os seguintes endpoints

1 GET /items
retornar todos os items

2 POST /items
receber json no body
crie validação para os campos que vier do body
- id
- nome
validar o se o id ja existe
salvar no array
retornar 201 com o item criado

3 DELETE /items/:id
precisa ser removido pelo id

salve os prompts que estou enviando em um arquivo PormptsVibe.md
