const form = document.querySelector('form');

const saida = () => {
    let peso = document.querySelector('#peso').value;
    let altura = document.querySelector('#altura').value;
    const imc = peso / (altura * altura);

    if(imc < 18.5){
        result = 'Magreza';  
    } else if(imc > 18.5 && imc < 24.9){
        result = 'Normal';
    } else if(imc > 25.0 && imc < 29.9){
        result = 'Sobrepeso';
    } else if(imc > 30.0 && imc < 39.9){
        result = 'Obesidade';
    } else if (imc > 40.0){
        result = 'Obesidade grave';
    }

    document.querySelector('#result').innerHTML = `Seu imc: ${imc} ${result}`;
}

form.addEventListener('submit', function(event) {
    event.preventDefault();
    saida();
})