package org.poo.armazenamento;

import java.util.ArrayList;
import java.util.List;

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

        /*
        Por agora vamos realizar a implementação com um laço simples. Entretanto, como descrito no comentário anterior, reflitam a respeito de uma solução
        alternativa...
        */

        Anel anelParaRemover = null;
        for(Anel anel: this.listaAnel){
            
            if(anel.getId() == id){
                anelParaRemover = anel;
                break;
            }
        }

        /*

        Veja a documentação do método remove() da interface java.util.List,
        e da classe java.util.ArrayList.

        */
        return this.listaAnel.remove(anelParaRemover);
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

        //PARA IMPLEMENTAR
        return 0;
    }

    /*
    Remove um anel a utilizar o diametro como elemento de identificação para remoção.
    Retorna o número de anéis que foram encontrados com o referido diametro, e removidos do armazenamento; retorna zero (0), caso nenhum anel com o referido diâmetro seja removido.
    */
    public Integer removeAnel(Integer diametro){

        //PARA IMPLEMENTAR
        return 0;
    }
}
