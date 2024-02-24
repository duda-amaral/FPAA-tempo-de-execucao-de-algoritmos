package aplicacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import entidades.*;
import javax.management.InvalidAttributeValueException;

public class PerformanceTester {

    final static double NANO_TO_MS = 1_000_000d;
    final static double MS_TO_SEC = 1_000d;
    static Random rand = new Random(42);

    public static void testArrayList(int P, int N) throws InvalidAttributeValueException {

        long ini = System.nanoTime();

        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();

        for (int i = 1; i <= P; i++) {
            listaDePessoas.add(new Pessoa(i, "Pessoa " + i));
        }

        for (int i = 0; i < N; i++) {
            int chave = rand.nextInt(P);
            for (Pessoa pessoa : listaDePessoas) {
                if (pessoa.getId() == chave) {
                    break;
                }
            }
        }

        long fim = System.nanoTime();

        System.out.println("P = " + P + "\nN = " + N);
        calcularTempo(ini, fim);
    }

    public static void testHashMap(int P, int N) throws InvalidAttributeValueException {

        long ini = System.nanoTime();

        HashMap<Integer, Pessoa> mapaPessoas = new HashMap<>();

        for (int i = 1; i <= P; i++) {
            mapaPessoas.put(i, new Pessoa(i, "Pessoa " + i));
        }

        for (int i = 0; i < N; i++) {
            int chave = rand.nextInt(P);
            mapaPessoas.get(chave);
        }

        long fim = System.nanoTime();

        System.out.println("P = " + P + "\nN = " + N);
        calcularTempo(ini, fim);

    }

    public static void calcularTempo(Long ini, Long fim) {
        double tempoMs = (fim - ini) / NANO_TO_MS;
        double tempoSeg = tempoMs / MS_TO_SEC;
        System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                + String.format("%.4f", tempoSeg) + " segundos).");
    }
}
