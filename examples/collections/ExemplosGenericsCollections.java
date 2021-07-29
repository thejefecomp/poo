import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
  Esta classe apresenta exemplos de utilização das coleções 
  especificadas por meio das interfaces java.util.List e 
  java.util.Set, a incluir um método genérico para impressão 
  das referidas coleções.
*/

public class ExemplosGenericsCollections{

    /*
      Este método apresenta um exemplo de implementação
      de impressão de coleções de forma genérica.
    */
    public static void imprimeColecao(Collection<?> colecao){

        System.out.println("===Início Coleção===");

        for(Object elemento : colecao) System.out.println(elemento);
        /*
        Com o uso de Streams, ficaria:

        colecao.stream().forEach(elemento -> System.out.println(elemento));
        */
        
        System.out.println("===Fim    Coleção===");
    }


    /*
        Este método apresenta exemplos de adição e remoção
        de elementos em Listas (List).
    */
    public static void adicionaRemoveNaLista(){

        System.out.println("@@@ Exemplos de Uso de Lista @@@");

        List<String> lFrutas = new ArrayList<>();

        System.out.println("Adição simples de elementos.");
        lFrutas.add("Laranja");
        lFrutas.add("Manga");
        lFrutas.add("Melão");

        imprimeColecao(lFrutas);

        System.out.println("Adição de elemento em posição específica com deslocamento.");
        
        lFrutas.add(1,"Limão");

        imprimeColecao(lFrutas);

        List<Integer> lNumeros = new ArrayList<>();

        System.out.println("Adição simples de elementos.");
        lNumeros.add(10);
        lNumeros.add(3);
        lNumeros.add(25);
        lNumeros.add(39);

        imprimeColecao(lNumeros);
    }

    /*
        Este método apresenta exemplos de adição e remoção
        de elementos em Conjunto (Set).
    */
    public static void adicionaNoConjunto(){

        System.out.println("@@@ Exemplos de Uso de Conjunto @@@");

        Set<String> sHerois = new HashSet<>();

        System.out.println("Adição simples de elementos.");
        sHerois.add("Capitão América");
        sHerois.add("Homem-Aranha");
        sHerois.add("Homem-de-Ferro");
        sHerois.add("Capitão América");

        imprimeColecao(sHerois);
    }

    /*
        Definição do método principal para a 
        execução dos métodos com os exemplos.
    */
    public static void main(String ...args){

        adicionaRemoveNaLista();

        adicionaNoConjunto();
    }
}