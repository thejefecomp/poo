// Esta classe contém exemplos de código com laços.

public class ExemplosWhile{


    public static void main(String ...args){

        int[] vetor = new int[10];

        //Exemplo1 - while
        System.out.println("Exemplo1 - while");
        int i = -1;
        while (++i < 10){
            vetor[i] = i*3;
            System.out.printf("vetor[%d] = %d\n", i,vetor[i]);
        }

        //Exemplo2 - while
        System.out.println("Exemplo2 - while");
        i = 0;
        while (i < 10){
            vetor[i] = i*3;
            System.out.printf("vetor[%d] = %d\n", i,vetor[i]);
            i++;
        }

        //Exemplo3 - while
        System.out.println("Exemplo3 - while");
        i = 9;
        while (i >= 0){
            vetor[i] = i*3;
            System.out.printf("vetor[%d] = %d\n", i,vetor[i]);
            i--;
        }

        //Exemplo4 - do-while
        System.out.println("Exemplo4 - do-while");
        i = 0;
        do{
            vetor[i] = i*3;
            System.out.printf("vetor[%d] = %d\n", i,vetor[i]);
            i++;
        }
        while(i < 10);
    }
}
