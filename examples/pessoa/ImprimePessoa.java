/*
Esta classe especifica um exemplo de programa em Java que imprime o valor dos atributos de um conjunto de objetos da classe Pessoa, instanciados dentro do método main().
*/

public class ImprimePessoa{


    /*
    Este método imprime os valores dos atributos de uma instância da classe pessoa,
    onde cada atributo é impresso em uma linha distinta. Será que conseguimos utilizar o método imprimePessoa() sem uma instância da classe ImprimePessoa? Resposta: Não, como pode ser visto abaixo no código fonte.
    */
    void imprimePessoa(Pessoa pessoa){

        System.out.println(pessoa.getId());
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getSobrenome());
    }
    
    public static void main(String ... args){

       /*
        Instâncias de objetos da classe Pessoa,
       juntamente com a atribuição de valores
       para os seus atributos por meio dos métodos
       set<nomeDoAtributo>().
       */
       Pessoa pessoaJoao = new Pessoa();
       pessoaJoao.setId(1L);
       pessoaJoao.setNome("João");
       pessoaJoao.setSobrenome("Couves");

       Pessoa pessoaZeca = new Pessoa();
       pessoaZeca.setId(2L);
       pessoaZeca.setNome("Zeca");
       pessoaZeca.setSobrenome("Neves");

       /*
       Instância da classe ImprimePessoa para poder utilizar o método imprimePessoa(). Qual seria a forma de utilizar o método imprimePessoa() sem uma instância da
       classe ImprimePessoa? Resposta: declarar o método como estático por meio da
       palavra reservada static (Veremos no tópico de encapsulamento os diferentes 
       escopos assumidos por todos os tipos de variáveis, em relação aos diferentes modificadores de acesso.)
       */
       ImprimePessoa impressao = new ImprimePessoa();

       impressao.imprimePessoa(pessoaJoao);
       impressao.imprimePessoa(pessoaZeca);

       /*
        Caso o desejo fosse criar muitos objetos do tipo pessoa, e imprimir todos os
        seus valores, qual a estratégia que poderíamos adotar com os conhecimentos 
        que temos até o momento? Pergunta para pensar até o próximo BatEncontro, ou para quem prefere StarWars, até a próxima instrução do treinamento Padawan :-D.
       */
       
    }

}