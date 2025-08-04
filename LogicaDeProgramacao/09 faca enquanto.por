programa {
  funcao inicio() {
    // declaração
    inteiro opcao
    real x, y, result

    // loop
    faca {
        // menu
        escreva("\n1 - soma \n" )
        escreva("2 - subtração \n")
        escreva("3 - multiplicação \n")
        escreva("4 - divisão \n")
        escreva("0 - Encerrar \n")
        escreva("Informe a opção desejada: \n")
        leia (opcao)


        //
        se (opcao >= 1 e opcao <= 4) {
            escreva("Valor de x: ")
            leia(x)
            escreva("Valor de y: ")
            leia(y)
        }

        // verificar a opção
        escolha (opcao) {
          caso 1:
        result = x + y
        escreva("\nResultado e: ", result)
        pare

        caso 2:
        result = x - y
        escreva("\nResultado e: ", result)
        pare

        caso 3:
        result = x * y
        escreva("\nResultado e: ", result)
        pare

        caso 4:
        result = x / y
        escreva("\nResultado e: ", result)
        pare

        caso 5:
        result = x / y
        escreva("Encerrado!")
        pare

        caso contrario:
         ("Opção inválida")
        }
    } enquanto (opcao != 0)
  }
}
