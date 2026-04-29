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