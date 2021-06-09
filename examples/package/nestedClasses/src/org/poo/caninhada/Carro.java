package org.poo.caninhada;


import java.util.ArrayList;
import java.util.List;

/*Esta classe representa a definição de um carro, a utilizar classes aninhadas. A classe roda é definida como classe membro da classe Carro.

Nesta etapa, onde ainda não temos conhecimento dos conceitos de Generalização, Especialização (Realização), Agregação, e Composição, vamos trabalhar com uma implementação mais auto-contida. Voltaremos nesta implementação para separá-la em diferentes domínios quando os referidos conceitos forem abordados.

Estado do exemplo: Work-in-progress.
*/
public class Carro{

    public class Roda{

        private String descricao;
        
        private Long numeroSerie;

        private Integer tamanhoAro;

        
        public String getDescricao(){
            return this.descricao;
        }

        public void setDescricao(String descricao){
            this.descricao = descricao;
        }

        public Long getNumeroSerie(){
            return this.numeroSerie;
        }

        public void setNumeroSerie(Long numeroSerie){
            this.numeroSerie = numeroSerie;
        }

        public Integer getTamanhoAro(){
            return this.tamanhoAro;
        }

        public void setTamanhoAro(Integer tamanhoAro){
            this.tamanhoAro = tamanhoAro;
        }

    }

    private String nome;

    private List<Roda> listaRodas;

    public boolean adicionaRoda(){
        return this.adicionaRoda(null);
    }

    public boolean adicionaRoda(Roda roda){

        if (this.listaRodas == null){
            this.listaRodas = new ArrayList<>();
        }
        else if(roda == null){
            roda = new Roda();

            roda.setDescricao("Roda padrão POO aro 13");
            roda.setTamanhoAro(13);
            //Pensar em criar um número de série aleatório;
            roda.setNumeroSerie(1234567890L);
        }

        return this.listaRodas.add(roda);
    }

    public boolean removeRoda(){
        return this.removeRoda(null);
    }

    public boolean removeRoda(Long numeroSerie){

        if(this.listaRodas == null || this.listaRodas.isEmpty())
            return false;
        else if (numeroSerie == null){
            return this.listaRodas.remove(0) != null;
        }

        Roda rodaARemover = null;

        for(var roda : this.listaRodas){
            if (roda.getNumeroSerie() == numeroSerie){
                rodaARemover = roda;
                break;
            }
        }

        return this.listaRodas.remove(rodaARemover);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setListaRodas(List<Roda> listaRodas){
        this.listaRodas = listaRodas;
    }

    /*
    TAREFA: Modifiquem o método toString() para permitir que a impressão do objeto do tipo Carro possa exibir a quantidade de rodas e os atributos específicos de cada uma das rodas, a eliminar o maior número de linhas redundantes possível.
    */

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Carro\n");
        sb.append("Nome: ");
        sb.append(this.nome);
        sb.append("\n");
        sb.append("Rodas\n");
        
        if (this.listaRodas != null && !this.listaRodas.isEmpty()){
            
            for(var roda : this.listaRodas){

                sb.append("Número de Série: ");
                sb.append(roda.numeroSerie);
                sb.append("\n");
                sb.append("Descrição: ");
                sb.append(roda.descricao);
                sb.append("\n");
                sb.append("Tamanho do Aro: ");
                sb.append(roda.tamanhoAro);
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}