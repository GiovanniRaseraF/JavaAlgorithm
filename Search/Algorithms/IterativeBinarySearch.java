package JavaAlgorithm.Search.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class IterativeBinarySearch<T extends Comparable<T>> extends SearchAlgorithm<T>{

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
        return 0;
    }

    private int findIt(List<T> array, T value){
        int low, high, index, comparation;

        low = 0;
        high = array.size() - 1;

        while (low <= high) {
            index = (low + high) / 2;
            comparation = value.compareTo(array.get(index));
            if (comparation == 0) {
                return index;
            } else if (comparation < 0) {
                high = --index;
            } else {
                low = ++index;
            }
        }
        return -1;
    }
    @Override
    public int find(T[] array, T value) {
        return this.find(new ArrayWrapper<T>(array),value);
    }
}
