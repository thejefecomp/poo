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

        System.out.printf("Olá Módulo do %s!\n", pessoa.getNome());
    }
}