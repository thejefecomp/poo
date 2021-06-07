//Esta classe contém exemplos de código com condicionais.

public class ExemplosIf{

    public static void main(String ...args){

        boolean booleano = true;

//Exemplo1 - if
System.out.println("Exemplo1 - if");
        if(booleano){
            System.out.println("Exemplo1 - Valor: "+booleano);
        }

//Exemplo2 - if
System.out.println("Exemplo2 - if");
        if(booleano == true){
            System.out.println("Exemplo2 - Valor: "+booleano);
        }

//Exemplo3 - if
booleano = false;

        System.out.println("Exemplo3 - if");
        if(!booleano){
            System.out.println("Exemplo3 - Valor: "+booleano);
        }

//Exemplo4 - if
System.out.println("Exemplo4 - if");
        if(booleano){
            System.out.println("Não entrarei aqui...");
        }
        else{
            System.out.println("Exemplo4 - Valor: "+booleano);
        }

//Exemplo5 - if
System.out.println("Exemplo5 - if (sem chaves)");
        if(booleano)
            System.out.println("Não entrarei aqui...");
        else
            System.out.println("Exemplo5 - Valor: "+booleano); 

//Exemplo6 - if
int resultado = 5;
System.out.println("Exemplo6 - if (sem chaves)");
        if(resultado < 5)
            System.out.println("Não entrarei aqui...");
        else if (resultado > 5)
            System.out.println("Não entrarei aqui...");
        else
            System.out.println("Exemplo6 - Valor: "+resultado);
    }
}