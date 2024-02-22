import java.util.ArrayList;
import java.util.Random;

import javax.management.InvalidAttributeValueException;

public class App {
    public static void main(String[] args) throws Exception {
        
        testArrayList(100, 20);
    }

    public static void testArrayList(int P, int N) throws InvalidAttributeValueException {

        final double NANO_TO_MS = 1_000_000d;
        final double MS_TO_SEC = 1_000d; 
        long ini = System.nanoTime(); 

        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        Random rand = new Random(42);

        for(int i = 1; i <= P; i++) {
            listaDePessoas.add(new Pessoa(i, "Pessoa " + i));
        }

        for (int i = 0; i < N; i++) {
            int chave = rand.nextInt(P) + 1;
            for(Pessoa pessoa : listaDePessoas) {
                if(pessoa.getId() == chave) {
                    System.out.println(pessoa);
                    break;
                }
            }
        }

        long fim = System.nanoTime();
         
        double tempoMs = (fim-ini)/NANO_TO_MS;
        double tempoSeg = tempoMs/MS_TO_SEC;
        
        System.out.println("P = " + P + "\nN = " + N);
        System.out.println("Finalizado em "+ String.format("%.2f",tempoMs)+" ms ("
                                          +  String.format("%.4f",tempoSeg)+" segundos).");

    }
}
