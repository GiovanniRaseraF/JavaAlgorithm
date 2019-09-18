package JavaAlgorithm.Tools;

import java.util.Random;

public class Utils {
    private static final Random rand = new Random();

    /**
     * EFFECTS: Carica di valori casuali un array
     * @param array
     */
    public static void loadArray(Integer[] array){
        loadArray(array,100);
    }

    /**
     * EFFECTS: Carica di valori casuali un array
     * @param array
     */
    public static void loadArray(Integer[] array,int bound){
        for (int i = 0; i<array.length;i++) {
            int s = rand.nextInt(bound);
            array[i] = s;
        }
    }

    /**
     * Stampa a video un array
     * @param array
     * @param s
     */
    public static void printArray(Integer[] array,String s){
        System.out.print(s+" -- ");
        for (int i : array) {
            System.out.print(i+", ");
        }
        System.out.println(" --");
    }
}
