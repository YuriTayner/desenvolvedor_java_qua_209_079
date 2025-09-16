const linhasPorPagina = 8;  // <-- aqui define quantas linhas aparecem por página
let paginaAtual = 0;
const linhas = tabela.querySelectorAll('#linha');
const totalPaginas = Math.ceil(linhas.length / linhasPorPagina);
const totalLinhas = linhas.length / 8 ;
document.getElementById('totalLinhas').textContent = totalLinhas;

function mostrarPagina(indexPagina) {
  paginaAtual = indexPagina;
  const inicio = paginaAtual * linhasPorPagina;
  const fim = inicio + linhasPorPagina;

  linhas.forEach((tr, i) => {
    tr.style.display = (i >= inicio && i < fim) ? '' : 'none';
  });

  document.getElementById('paginaAtual').textContent = paginaAtual + 1;
}

// Atualizar botões "Anterior" e "Próximo"
document.getElementById('prevBtn').addEventListener('click', () => {
  if (paginaAtual > 0) {
    mostrarPagina(paginaAtual - 1);
  }
});

document.getElementById('nextBtn').addEventListener('click', () => {
  if (paginaAtual < totalPaginas - 1) {
    mostrarPagina(paginaAtual + 1);
  }
});

// Inicializa mostrando a primeira página
mostrarPagina(0);