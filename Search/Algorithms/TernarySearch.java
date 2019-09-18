package JavaAlgorithm.Search.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class TernarySearch<T extends Comparable<T>> extends SearchAlgorithm<T> {
    @Override
    public int find(List<T> array, T value) {
        return this.findIt(array,value,0,array.size()-1);
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
    private int findIt(List<T> array, T value, int start, int end){
        if (start > end) {
            return -1;
        }
        /* First boundary: add 1/3 of length to start */
        int mid1 = start + (end - start) / 3;
        /* Second boundary: add 2/3 of length to start */
        int mid2 = start + 2 * (end - start) / 3;

        if (super.eq(value,array.get(mid1))) {
            return mid1;
        } else if (super.eq(value,array.get(mid2))) {
            return mid2;
        }

        /* Search the first (1/3) rd part of the array.*/

        else if (super.lt(value,array.get(mid1))) {
            return findIt(array, value, start, --mid1);
        }
        /* Search 3rd (1/3)rd part of the array */

        else if (super.gt(value,array.get(mid2))) {
            return findIt(array, value, ++mid2, end);
        }
        /* Search middle (1/3)rd part of the array */

        else {
            return findIt(array, value, mid1, mid2);
        }
    }

    @Override
    public int find(T[] array, T value) {
        return this.find(new ArrayWrapper<T>(array),value);
    }
}
