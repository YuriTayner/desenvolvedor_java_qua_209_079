programa {
  funcao inicio() {
    // declaração
   cadeia nome 
   real nota

    // ENTRADA DE DADOS 
    escreva ("Informe seu nome:")
    leia (nome)

    escreva ("Informe seu nota:")
    leia (nota)

     // estrutura

    se (nota >= 0 e nota <= 10 ){
      se (nota >= 7) escreva(nome, " - APROVADO")

      senao se (nota >= 5) escreva (nome, " - RECUPERAÇÃO")

      senao escreva(nome, " - REPROVADO")

      } senao {
      escreva("Nota Inválida.")
    }
  }
}
