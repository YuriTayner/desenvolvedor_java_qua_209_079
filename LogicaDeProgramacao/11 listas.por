programa {
  funcao inicio() {
    cadeia nomes [10]
    inteiro idade [10]

    //entrada 
   para (inteiro i = 0; i < 10; i++) {
      escreva("escreva o nome da pessoa ", i + 1, ": ")
      leia(nomes[i])

      escreva("digite a idade da pessoa ", i + 1, ": ")
      leia(idade[i])
    }

    escreva("\nlista de pessoas:\n")
    para (inteiro i = 0; i < 10; i++) {
      escreva("pessoa ", i + 1, ": ", nomes[i], " - idade: ", idade[i], "\n")
    }


  }
}
