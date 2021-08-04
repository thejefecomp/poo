package org.poo.armazenamento;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;

import org.poo.entidade.Anel;


/*
A classe ArmazenaAnel realiza toda a gestão das operações de armazenamento dos anéis, a constituir uma camada de manipulação e transformação utilizada na gestão
das entidades do tipo org.poo.entidade.Anel armazenadas. Caso tenha-se que fazer
o armazenamento de mais de uma entidade, e.g. 100 entidades diferentes, o que seria comum às operações de armazenamento das diferentes entidades?
*/
public class ArmazenaAnel{

    /*
    Armazena a lista de anéis que foram adicionados por meio de um dos métodos adicionaAnel() presente nesta classe. Por agora esta lista pode ser definida como um atributo de ArmazenaAnel, já que no contexto da disciplina somente falou-se de forma incipiente sobre Padrões de Projeto. Entretanto, todo o armazenamento e código-fonte necessário para manipulação dos dados fica, usualmente, definido de outra forma.
    */
    private List<Anel> listaAnel;


    /*
       Este método retorna a quantidade de elementos
       removidos da lista interna de anéis, baseado
       em uma condição estabelecida pelo predicado 
       em questão.
    */
    private Integer removeIf(Predicate<Anel> condicao){

        int tamanhoAnterior = this.listaAnel.size();

        this.listaAnel.removeIf(condicao);

        return tamanhoAnterior - this.listaAnel.size();

        /*
           Implementação alternativa com operador ternário:

           int tamanhoAnterior = this.listaAnel.size();

           return this.listaAnel.removeIf(condicao) ? tamanhoAnterior - this.listaAnel.size() : 0;
        */
    }

    /*
    Construtor default (sem parâmetros).
    */
    public ArmazenaAnel(){

        this(new ArrayList<Anel>());
    }

    /*
    Construtor com um parâmetro.
    */
    public ArmazenaAnel(List<Anel> listaAnel){

        this.listaAnel = listaAnel;
    }

    /*
    Adiciona um anel, a especificar os valores dos atributos id, nome, e diametro.
    Retorna true (verdadeiro) caso o anel seja adicionado; retorna false (falso) caso contrário.
    */
    public boolean adicionaAnel(Long id,String nome, Integer diametro){

        return this.adicionaAnel(id,nome,null,diametro);
    }

    /*
    Adiciona um anel, a especificar os valores dos atributos id, nome, descricao, e diametro.
    Retorna true (verdadeiro) caso o anel seja adicionado; retorna false (falso) caso contrário.
    */
    public boolean adicionaAnel(Long id, String nome, String descricao, Integer diametro){

        Anel anel = new Anel(id,nome,descricao,diametro);

        return this.listaAnel.add(anel);
    }

    /*
    Remove um anel a utilizar o id como elemento de identificação para remoção.
    Retorna true (verdadeiro) se o anel com o referido id for encontrado e removido do armazenamento; retorna false (falso) caso contrário.

    Existem diferentes formas de implementar este método, com mais ou menos flexibilidade. Pensem em outras formas, realizem a implementação (caso necessário), e comparem com a implementação disponibilizada. Será que 
    consegue-se achar uma solução diferente? A documentação da linguagem
    Java pode nos ajudar?
    */
    public boolean removeAnel(Long id){

        
        Predicate<Anel> removePeloId = anel -> anel.getId().equals(id); //Alguma característica que identifica o critério de remoção;

        return this.removeIf(removePeloId) > 0;

        /*
          Implementação alternativa a invocar diretamente o removeIf da lista.

          return this.listaAnel.removeIf(removePeloId);
        */
    }

/*
===== DESCRIÇÃO DA TAREFA =====

Com os conhecimentos de Programação recebidos até o momento, analise as classes disponibilizadas e forneça uma implementação dos métodos para remover os anéis da lista pelo nome, e pelo diâmetro, métodos estes que estão definidos abaixo.

A considerar que não foram transmitidos conhecimentos acerca de testes automatizados, crie uma classe no pacote org.poo.armazenamento com o método main(), e realize operações de adição e remoção de anéis para verificar como a classe
org.poo.armazenamento.ArmazenaAnel comporta-se.

===== DESCRIÇÃO DA TAREFA =====
*/

    /*
    Remove um anel a utilizar o nome como elemento de identificação para remoção.
    Retorna o número de anéis que foram encontrados com o referido nome, e removidos do armazenamento; retorna zero (0), caso nenhum anel com o referido nome seja removido.
    */
    public Integer removeAnel(String nome){

         Predicate<Anel> removePeloNome = anel -> anel.getNome().equals(nome);

        return this.removeIf(removePeloNome);
    }

    /*
    Remove um anel a utilizar o diametro como elemento de identificação para remoção.
    Retorna o número de anéis que foram encontrados com o referido diametro, e removidos do armazenamento; retorna zero (0), caso nenhum anel com o referido diâmetro seja removido.
    */
    public Integer removeAnel(Integer diametro){
 
        Predicate<Anel> removePeloDiametro = anel -> anel.getDiametro().equals(diametro);
        
        return this.removeIf(removePeloDiametro);
    }

    public static void main(String ...args){

        ArmazenaAnel storage = new ArmazenaAnel();

        storage.adicionaAnel(1L,"Pipoca", 10);
        storage.adicionaAnel(2L,"Peso", 15);
        storage.adicionaAnel(3L,"Pipoca", 13);

        System.out.printf("Número de anéis removidos: %d\n",storage.removeAnel("Pipoca"));
    }
}