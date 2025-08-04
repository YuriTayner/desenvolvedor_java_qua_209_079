programa {
  funcao inicio() {
     // declaração
   cadeia nome 
   caracter genero
   inteiro idade

    // ENTRADA DE DADOS 
    escreva ("Informe seu nome:")
    leia (nome)

    escreva ("Informe sua idade:")
    leia (idade)

    escreva ("Informe seu sexo: M/F")
    leia (genero)

     // estrutura

    se (genero == "M" e idade >= 65) {
      escreva(nome, " está apto para se aposentar.")
    } senao se (genero == "F" e idade >= 62) {
      escreva(nome, " está apto para se aposentar.")
    } senao {
      escreva(nome, " não está apto para se aposentar.")
    }
  }
}
