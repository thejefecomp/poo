package org.poo.entidade;

import org.poo.interfaces.entidade.IEntidade;

/*
Esta classe especifica uma representação simples de 
uma entidade do tipo Pessoa.
*/

public class Pessoa implements IEntidade{

    private String nome;

    public String getNome(){

        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}