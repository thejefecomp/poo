package org.poo.principal;

import org.poo.entidade.Pessoa;

/*
Esta classe especifica um exemplo simples de classe que 
contém o método main(), a possibilitar sua execução por 
meio do módulo onde ela encontra-se encapsulada, i.e. 
modulo.poo.sensacional.
*/

public class Principal{

    public static void main(String ...args){

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Zequinha");

        System.out.printf("Olá Módulo do %s!\nDescrição: %s\n", pessoa.getNome(),pessoa.getDescricao());
        /*LEMBRANÇA: O método getDesricao() é um método default implementado na interface org.poo.interfaces.entidade.IEntidade, interface esta que 
        é concretizada pela classe org.poo.Entidade.Pessoa utilizada no método
        main().
        */
    }
}