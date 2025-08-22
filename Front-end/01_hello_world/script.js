// Seleciona o botão e o container
const button = document.getElementById('btnColor');
const conteiner = document.getElementById('conteiner');

// Função para alterar o fundo do container
button.addEventListener('click', function() {
    // Definindo uma cor aleatória de fundo
    conteiner.style.backgroundColor = getRandomColor();
});

// Função para gerar uma cor aleatória em formato hexadecimal
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}