package org.poo.entidade;

/*
Especifica uma entidade chamada Anel, presente no pacote org.poo.entidade.
A entidade Anel especifica os atributos diametro e o nome,
a possuir métodos get() e set() associados à cada um dos referidos
atributos. Além disso, a classe Anel define dois construtores para auxiliar
na criação de objetos.
*/

public class Anel extends Entidade{

    private Integer diametro;

    private String nome;

    /*
    Construtor default (sem argumentos)
    */
    public Anel(){

        this(null,null,null,null);

    }

    /*
    Construtor adicional com argumentos.
    */
    public Anel(Long id, String nome, String descricao, Integer diametro){

        super(id,descricao);

        this.nome = nome;

        this.diametro = diametro;
    }

    public Integer getDiametro(){
        return this.diametro;
    }

    public void setDiametro(Integer diametro){
        this.diametro = diametro;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}