/*
Esta classe representa um entidade denominada Pessoa.
Não vamos nos preocupar com os modificadores de acesso na
definição dos atributos (por enquanto).
*/
public class Pessoa{

    Long id;

    String nome;

    String sobrenome;


    public Long getId(){

        return this.id;

    }

    public void setId(Long id){

        this.id = id;
    }

    public String getNome(){

        return this.nome;

    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public String getSobrenome(){

        return this.sobrenome;

    }

    public void setSobrenome(String sobrenome){

        this.sobrenome = sobrenome;
    }
}


