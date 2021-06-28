package org.poo.interfaces.entidade;

/*
Esta interface representa um exemplo de interface a definir
um comportamento comum (i.e. método default getDescricao()) à todas
as classes que a concretizarem. No contexto do exemplo associado
com dependências trasitivas, a classe org.poo.entidade.Pessoa, do módulo modulo.poo.entidade, é a única classe a realizar tal
concretização.
*/

public interface IEntidade{

    /*
    Define um comportamento padrão, o qual pode ser 
    utilizado sem a necessidade de um implementação
    específica na classe que concretizar esta interface.
    */
    public default String getDescricao(){

        return this.toString();
    }
}