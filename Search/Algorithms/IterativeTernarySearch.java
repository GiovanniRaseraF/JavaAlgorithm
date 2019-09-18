package JavaAlgorithm.Search.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class IterativeTernarySearch<T extends Comparable<T>> extends SearchAlgorithm<T> {
    @Override
    public int find(List<T> array, T value) {
        return this.findIt(array,value);
    }

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
    private int findIt(List<T> array, T value){
        int left = 0;
        int right = array.size() - 1;

        while (right > left) {

            int leftCmp = array.get(left).compareTo(value);
            int rightCmp = array.get(right).compareTo(value);
            if (leftCmp == 0) return left;
            if (rightCmp == 0) return right;

            int leftThird = left + (right - left) / 3 + 1;
            int rightThird = right - (right - left) / 3 - 1;


            if (super.le(array.get(leftThird),value)) {
                left = leftThird;
            } else {
                right = rightThird;
            }
        }

        return -1;
    }

    @Override
    public int find(T[] array, T value) {
        return this.find(new ArrayWrapper<T>(array),value);
    }
}
