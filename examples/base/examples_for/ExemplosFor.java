// Esta classe contém exemplos de código com laços.

public class ExemplosFor{


    public static void main(String ...args){

        int[] vetor = new int[10];

        
        //Exemplo1 - for
        System.out.println("Exemplo1 - for");
        for(int i = 0; i < 10; i++){
            vetor[i] = i*3;
            System.out.printf("vetor[%d] = %d\n", i,vetor[i]);
        }

        //Exemplo2 - for
        System.out.println("Exemplo2 - for");
        for(int i = 1; i < 11; i++){
            System.out.println(i);
        }

        //Exemplo3 - for
        System.out.println("Exemplo3 - for (sem chaves)");
        for(int i = 1; i < 11; i++)
            System.out.printf("%d (for sem chaves)\n", i);

        
        //Exemplo4 - for
        System.out.println("Exemplo4 - for (sem chaves)");
        int i = 1;
        for(; i < 11; i++)
            System.out.printf("%d (for sem chaves)\n", i);


        //Exemplo5 - foreach (vale também para coleções)
        System.out.println("Exemplo5 - foreach");
        for(int valor:vetor){
            System.out.printf("valor= %d\n",valor);
        }

        //Exemplo6 - foreach com var (vale também para coleções)
        System.out.println("Exemplo6 - foreach com var");
        for(var valor:vetor){
            System.out.printf("valor= %d\n",valor);
        }

    }
}