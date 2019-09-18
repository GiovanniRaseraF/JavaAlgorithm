package JavaAlgorithm.Sort;

import JavaAlgorithm.Sort.Algorithms.SortAlgorithm;
import JavaAlgorithm.Tools.Utils;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] arraySimple = new Integer[21];
        Utils.loadArray(arraySimple);
        for(Sorter.Algorithm alg : Sorter.Algorithm.values()){
            if(alg.name().equals("BOGO")) continue;
            System.out.println("\n\n"+alg.name());
            Sorter.sort(arraySimple,SortAlgorithm.Direction.CRESCENTE,alg);
            Utils.printArray(arraySimple,"CRE");
            Sorter.sort(arraySimple,SortAlgorithm.Direction.DECRESCIENTE,alg);
            Utils.printArray(arraySimple,"DEC");
        }


    }
}
