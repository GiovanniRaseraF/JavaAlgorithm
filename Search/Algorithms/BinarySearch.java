package JavaAlgorithm.Search.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> extends SearchAlgorithm<T>{
    /**
     * REQUIRE: array != null && value != null , array oridinato in modo CRESCENTE
     * CONSIGLI: per ordinare array utilizzare la classe Sorter
     * ES : !! Sorter.sort(arraySimple,SortAlgorithm.Direction.CRESCENTE,Sorter.Algorithm.QUICK);
     * IMPORTANTE: L'array deve essere Ordinato in modo CRESCIENTE, se non lo è un risultato consono non è garantito
     * E possibile un esecuzione non definita o un loop infinito se l'array non fosse ordinato in modo CRESCENTE
     * Se l'array non è ordinato utilizzare una ricerca LINEAR o altri tipi di ricerca che non richiedono un
     * array ordinato
     * EFFECTS: Ritorna la posizione in cui è value in array
     * Se value non è in array ritorna -1
     * @param array
     * @param value
     * @return
     */
    @Override
    public int find(List<T> array, T value) {
        if(array == null || value == null) throw new NullPointerException("Search.Binary : : array e valore non possono essere null");
        return this.findIt(array,value,0,array.size());
    }

    private int findIt(List<T> array,T value, int left, int right){
        if (right < left) return -1; // this means that the key not found
        // find median
        int median = (left + right) >>> 1;
        int comp = value.compareTo(array.get(median));
        if (comp < 0) {
            return findIt(array, value, left, median - 1);
        }

        if (comp > 0) {
            return findIt(array, value, median + 1, right);
        }
        return median;
    }

    @Override
    public int find(T[] array, T value) {
        return this.find(new ArrayWrapper<T>(array),value);
    }
}
