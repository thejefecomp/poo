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

    /*
    SOLUÇÃO: Implementar uma Classe Local (ao método) que resolve a impressão. A implementação leva muito pouco tempo para ser realizada (aprox. 15 minutos) e permite uma melhor manutenibilidade e extensibilidade do código-fonte.


    DETALHES:

    Linhas de código efetivas na implementação nova com pouca redundância(sem contabilizar comentários, espaços, e fechamento das chaves): 24 linhas;

    Linhas de código efetivas na implementação anterior com muita redundância (sem contablizar comentários, espaços, e fechamento das chaves): 18 linhas;

    No Caso da implementação anterior, cada vez que acrescentamos um novo atributo na classe Carro, ou na classe Roda, temos 3 linhas a serem adicionadas (por atributo), a aumentar a redundância do código-fonte.

    No caso da nova implementação podemos acrescentar uma linha nova (caso desejado), ou simplesmente adicionar os atributos a uma das chamadas do método imprime() já efetuadas.

    */
    @Override
    public String toString(){

        /*
        Esta classe auxilia na conversão de um objeto do tipo Carro para um
        objeto to tipo String.
        */
        class CarroToString{

            private StringBuilder sbCarro = new StringBuilder();

            /*
            Este método imprime cada item em uma linha separada, a reconhecer
            a presença de um cabeçalho de impressão.
            */
            public void imprime(String separadorLinha, String separadorCampo, boolean cabecalho,String ...valores){

                for(int i = 0; i < valores.length; i++){

                    sbCarro.append(valores[i]);

                    if((cabecalho && i == 0) ||
                       (cabecalho && (i % 2 == 0) ||
                       i == valores.length - 1)){

                        sbCarro.append(separadorLinha);
                    }
                    else if(!cabecalho && (i + 1) % 2 == 0){

                        sbCarro.append(separadorLinha);

                    }
                    else{

                        sbCarro.append(separadorCampo);
                    }
                }

            }

            /*
            Este método imprime uma instância da classe Carro, 
            a ter incremento mínimo do número de linhas (caso desejado pelo desenvolvedor) de forma independente ao número de atributos nas classes Roda e Carro. 
            */
            public String imprime(Carro carro){

                sbCarro.setLength(0);

                this.imprime("\n", ": ", true,"Carro","Nome",carro.nome);

                this.imprime("\n",": ", true, "Rodas", "Quantidade", Integer.valueOf(carro.listaRodas != null ? carro.listaRodas.size(): 0).toString());
                if (carro.listaRodas != null && !carro.listaRodas.isEmpty()){

                    for(var roda : carro.listaRodas){
                        this.imprime("\n", ": ", false, "Número de Serie",roda.getNumeroSerie().toString(), "Descrição", roda.getDescricao(), "Tamanho do Aro", roda.getTamanhoAro().toString());
                    }
                }

                return sbCarro.toString();
            }

        }


        CarroToString converteCarro = new CarroToString();

        return converteCarro.imprime(this);


    /*

        Implementação Anterior (com muita redundância).
        
        StringBuilder sb = new StringBuilder();

            sb.append("Carro\n");
            sb.append("Nome: ");
            sb.append(this.nome);
            sb.append("\n");
            sb.append("Rodas\n");
            
            if (this.listaRodas != null && !this.listaRodas.isEmpty()){
                
                for(var roda : this.listaRodas){

                    sb.append("Número de Série: ");
                    sb.append(roda.getNumeroSerie());
                    sb.append("\n");
                    sb.append("Descrição: ");
                    sb.append(roda.getDescricao());
                    sb.append("\n");
                    sb.append("Tamanho do Aro: ");
                    sb.append(roda.getTamanhoAro());
                    sb.append("\n");
                }
            }

            return sb.toString();
        */
    }
}