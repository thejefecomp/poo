/*
Este arquivo declara o módulo chamado modulo.poo.entidade,
a exportar o pacote org.poo.entidade para ser utilizado 
pelo módulo chamado modulo.poo.sensacional, e a declarar
uma dependência transitiva com o módulo modulo.poo.interfaces.
*/
module modulo.poo.entidade{

   requires transitive modulo.poo.interfaces;

   exports org.poo.entidade;
}