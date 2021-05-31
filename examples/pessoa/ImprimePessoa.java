/*
Esta classe especifica um exemplo de programa em Java que imprime o valor dos atributos de um conjunto de objetos da classe Pessoa, recebidos na entrada padrão por meio de arquivo (default: pessoas.in)
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
       Instância da classe ImprimePessoa para poder utilizar o método imprimePessoa(). Qual seria a forma de utilizar o método imprimePessoa() sem uma instância da
       classe ImprimePessoa? Resposta: declarar o método como estático por meio da
       palavra reservada static (Veremos no tópico de encapsulamento os diferentes 
       escopos assumidos por todos os tipos de variáveis, em relação aos diferentes modificadores de acesso.)
       */
       ImprimePessoa impressao = new ImprimePessoa();


        java.util.Scanner scanner = new java.util.Scanner(System.in);



        while(scanner.hasNext()){

            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextLong());
            //Sem espaços no nome e no sobrenome
            //Tarefa para casa: Modificar essa implementação para suportar nomes compostos com espaços.
            pessoa.setNome(scanner.next()); 
            pessoa.setSobrenome(scanner.next());

            impressao.imprimePessoa(pessoa);            
        }

        scanner.close();
       
    }

}
