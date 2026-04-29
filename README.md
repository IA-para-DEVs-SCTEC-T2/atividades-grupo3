# Detector de Duplicatas

Projeto de exemplo que compara duas implementações para detectar duplicatas em um array: a versão anterior e a versão otimizada com IA.

## Arquivos

| Arquivo | Descrição |
|---|---|
| `main.js` | Versão do colega e versão otimizada com IA, com análise comparativa |

## O problema

Dado uma lista de números, determinar se contém algum valor duplicado.

```js
hasDuplicate([1, 2, 3, 3]) // → true
hasDuplicate([1, 2, 3, 4]) // → false
```

## Comparação das versões

### Versão anterior
Usa um `Set` auxiliar dentro de um loop `for...of`. Retorna `true` assim que encontra o primeiro duplicado (early return), o que é eficiente quando a duplicata aparece no início do array.

```js
function has_duplicate(lista) {
  const vistos = new Set();
  for (const numero of lista) {
    if (vistos.has(numero)) return true;
    vistos.add(numero);
  }
  return false;
}
```

### Versão IA
Converte o array diretamente para `Set` e compara os tamanhos. Mais concisa e declarativa, mas sempre percorre o array inteiro.

```js
function hasDuplicate(nums) {
  return new Set(nums).size < nums.length;
}
```

## Quando usar cada uma

| Situação | Recomendação |
|---|---|
| Arrays grandes com duplicatas no início | Versão do colega (early return) |
| Código conciso e legível em geral | Versão IA |
| Ambas são corretas e O(n) | Escolha por preferência de estilo |

## Como executar

```bash
node main.js
```

Requer [Node.js](https://nodejs.org) instalado.
