package org.poo.caninhada.main;


import org.poo.caninhada.Carro;
import org.poo.caninhada.Carro.Roda;

/* Esta classe representa um exemplo de classe Principal, a declarar o método main,
o qual é utilizado como base de execução de exemplos associados às classes aninhadas.

Estado do exemplo: Work-in-progress.
*/
public class Principal{

    public static void main(String ...args){

        Carro carro = new Carro();
        carro.setNome("Fusca");

        Roda roda = carro.new Roda();

        roda.setDescricao("Roda criada no main aro 13");
        roda.setTamanhoAro(13);
        roda.setNumeroSerie(1234568790L);
        
        carro.adicionaRoda(roda);

        System.out.println(carro);
        
    }
}