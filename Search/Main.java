package JavaAlgorithm.Search;

import JavaAlgorithm.Sort.Algorithms.SortAlgorithm;
import JavaAlgorithm.Sort.Sorter;
import JavaAlgorithm.Tools.ArrayWrapper;
import JavaAlgorithm.Tools.Utils;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static final int LEN = 20;
    public static void main(String[] args) {
        Integer[] array = new Integer[LEN];
        Utils.loadArray(array,20);
        Integer[] arraySort = new Integer[LEN];
        System.arraycopy(array,0,arraySort,0,LEN);
        Sorter.sort(arraySort,SortAlgorithm.Direction.CRESCENTE,Sorter.Algorithm.QUICK);
        Integer value = 13;

        String[] s = {"BINARY","INTERPOLATION","ITERATIVEBINARY","TERNARY","ITERATIVETERNARY"};
        ArrayWrapper<String> sorted = new ArrayWrapper<String>(s);

        for(Searcher.Algorithm alg : Searcher.Algorithm.values()){
            if(sorted.contains(alg.name())){
                int pos = Searcher.find(arraySort,value,alg);
                System.out.println(alg.name());
                Utils.printArray(arraySort,""+value+" at "+pos+" ");
            }else{
                int pos = Searcher.find(array,value,alg);
                System.out.println(alg.name());
                Utils.printArray(array,""+value+" at "+pos+" ");
            }

        }
    }
}
