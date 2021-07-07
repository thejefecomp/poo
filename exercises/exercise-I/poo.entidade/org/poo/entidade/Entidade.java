package org.poo.entidade;


/*
Especifica uma classe abstrata chamada Entidade, a qual está presente no pacote org.poo.entidade. A classe abstrata Entidade define dois atributos, id e descricao, os quais são comuns a todas as suas classes herdeiras. Cada um dos referidos atributos possui métodos get() e set() associados. Além disso, a classe abstrata Entidade define dois construtores para auxiliar na criação de objetos.
*/
public abstract class Entidade{

    private Long id;

    private String descricao;

    /*
    Construtor default (sem argumentos)
    */
    public Entidade(){

        this(null,null);
    }

    /*
    Construtor adicional com argumentos.
    */
    public Entidade(Long id, String descricao){

        this.id = id;

        this.descricao = descricao;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}