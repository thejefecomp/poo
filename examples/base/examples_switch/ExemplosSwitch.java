//Esta classe contém exemplos de código com estruturas de seleção.

public class ExemplosSwitch{

    public static void main(String ...args){

        //Exemplo1 - switch
        int numero = 2;
        System.out.println("Exemplo1 - switch");
        switch(numero){

            case 1: System.out.printf("Não entrarei no caso 1\n");
            break;
            case 2: System.out.printf("Número %d selecionado\n", numero);
            break;

            default: System.out.printf("Não entrarei neste caso default\n");
        }


        //Exemplo2 - switch
        numero = 1;
        System.out.println("Exemplo2 - switch sem break");
        switch(numero){

            case 1: System.out.printf("Número %d selecionado\n", numero);
            case 2: System.out.printf("Entro também no caso 2\n");
            break;

            default: System.out.printf("Não entrarei neste caso default\n");
        }

        //Exemplo3 - switch
        char letra = 'A';
        System.out.println("Exemplo3 - switch");
        switch(letra){

            case 'A': System.out.printf("Letra %c selecionado\n", letra);
            break;
            case 'B': System.out.printf("Não entrarei neste caso B\n");
            break;

            default: System.out.printf("Não entrarei neste caso default\n");
        }

        //Exemplo4 - switch
        String fruta = "Banana";
        System.out.println("Exemplo4 - switch");
        switch(fruta){

            case "banana": System.out.printf("Não entrarei neste caso banana (com letra minúscula)\n");
            break;
            case "Banana": System.out.printf("Fruta %s selecionada\n", fruta);
            break;

            default: System.out.printf("Não entrarei neste caso default\n");
        }
    }
}