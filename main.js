// ============================================================
// VERSÃO ANTERIOR (do colega)
// ============================================================
// Usa um Set para rastrear elementos já vistos durante o loop.
// Retorna true assim que encontra um duplicado — early return eficiente.
// Lógica correta, legível e funcional.

function has_duplicate(lista) {
  const vistos = new Set();

  for (const numero of lista) {
    if (vistos.has(numero)) {
      return true;
    }
    vistos.add(numero);
  }

  return false;
}

console.log(has_duplicate([1, 2, 3, 3])); // true


// ============================================================
// VERSÃO OTIMIZADA COM IA
// ============================================================

// OTIMIZAÇÃO 1: Eliminação do loop explícito
// A versão do colega itera manualmente com for...of e mantém um Set auxiliar.
// A versão IA converte o array diretamente para Set e compara tamanhos — mais declarativo.

// OTIMIZAÇÃO 2: Menos memória de controle
// O colega cria um Set vazio e vai adicionando elemento por elemento.
// A versão IA cria o Set de uma vez só, sem operações intermediárias.

// OTIMIZAÇÃO 3: Early return vs retorno direto
// O colega usa early return (bom para arrays grandes com duplicata no início).
// A versão IA sempre percorre o array inteiro — trade-off: menos código, mas sem early return.

// OTIMIZAÇÃO 4: camelCase (hasDuplicate) — convenção padrão do JavaScript.

// OTIMIZAÇÃO 5: Casos extremos cobertos (array vazio retorna false corretamente).

function hasDuplicate(nums) {
  return new Set(nums).size < nums.length;
}

console.log(hasDuplicate([1, 2, 3, 3])); // true  — há um 3 repetido
console.log(hasDuplicate([1, 2, 3, 4])); // false — todos únicos
console.log(hasDuplicate([]));            // false — array vazio

// ============================================================
// RESUMO DAS OTIMIZAÇÕES
// ============================================================
//
// | Aspecto               | Versão Anterior                   | Versão IA                          |
// |-----------------------|-----------------------------------|------------------------------------|
// | Lógica                | Correta com loop + Set auxiliar   | Correta com Set direto             |
// | Early return          | Sim — para em duplicata imediata  | Não — percorre o array inteiro     |
// | Linhas de código      | 10 linhas                         | 1 linha                            |
// | Legibilidade          | Clara e explícita                 | Concisa e declarativa              |
// | Convenção de nomes    | has_duplicate (snake_case)        | hasDuplicate (camelCase JS)        |
// | Complexidade de tempo | O(n) — melhor caso O(1)           | O(n) sempre                       |
// | Complexidade de espaço| O(n)                              | O(n)                               |
// | Casos extremos        | Cobertos                          | Cobertos                           |
// ============================================================
// Conclusão: ambas as versões são corretas e eficientes.
// A versão do colega tem vantagem em arrays com duplicatas no início (early return).
// A versão IA é mais concisa e idiomática para casos gerais.
// ============================================================
