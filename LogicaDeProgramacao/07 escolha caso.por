programa {
  funcao inicio() {
      // declaração
    inteiro opcao
    real x, y, result


    escreva("Valor de x: ")
    leia (x)

    // ENTRADA DE DADOS 
    escreva("Valor de y: ")
    leia (y)

    escreva("1 - soma \n" )
    escreva("2 - subtração \n")
    escreva("3 - multiplicação \n")
    escreva("4 - divisão \n")
    escreva("Informe a opção desejada: \n")
    leia (opcao)

    // escolha caso
    escolha(opcao)
    {
      caso 1:
        result = x + y
        escreva("O resultado e: ", result)
        pare

        caso 2:
        result = x - y
        escreva("O resultado e: ", result)
        pare

        caso 3:
        result = x * y
        escreva("O resultado e: ", result)
        pare

        caso 4:
        result = x / y
        escreva("O resultado e: ", result)
        pare

      caso contrario: 
        escreva("opção inválida")
    }


  }
}
