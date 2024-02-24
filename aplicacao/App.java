package aplicacao;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha: ");
        System.out.println("ArrayList: \n" + 
        "1 - P = 2.500.000 | N = 20.000 \n" +
        "2 - P = 5.000.000 | N = 20.000 \n" + 
        "3 - P = 10.000.000 | N = 20.000 \n" +
        "4 - P = 2.500.000 | N = 40.000 \n" +
        "HashMap: \n" +
        "5 - P = 2.500.000 | N = 20.000 \n" + 
        "6 - P = 5.000.000 | N = 20.000 \n" +
        "7 - P = 10.000.000 | N = 20.000 \n" +
        "8 - P = 2.500.000 | N = 40.000 \n");

        int opcao = ler.nextInt();    

        switch (opcao) {
            case 1:
                PerformanceTester.testArrayList(2500000, 20000);
                break;

            case 2:
                PerformanceTester.testArrayList(5000000, 20000);
                break;
            
            case 3:
                PerformanceTester.testArrayList(10000000, 20000);
                break;

            case 4:
                PerformanceTester.testArrayList(2500000, 40000);
                break;

            case 5:
                PerformanceTester.testHashMap(2500000, 20000);
                break;

            case 6:
                PerformanceTester.testHashMap(5000000, 20000);
                break;
                
            case 7:
                PerformanceTester.testHashMap(10000000, 20000);
                break;

            case 8:
                PerformanceTester.testHashMap(2500000, 40000);
                break;

            default:
                break;
        }

        ler.close();

    }
}
