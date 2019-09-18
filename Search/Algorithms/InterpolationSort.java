package JavaAlgorithm.Search.Algorithms;

import JavaAlgorithm.Sort.Algorithms.SortAlgorithm;
import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class InterpolationSort extends SearchAlgorithm<Integer> {


    /**
     * REQUIRE: array != null && value != null , array oridinato in modo CRESCENTE
     * l'array deve contenere Integer
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
    public int find(List<Integer> array, Integer value) {
        return this.findIt(array,value);
    }

    private int findIt(List<Integer> array, Integer value){
        // Find indexes of two corners
        int start = 0, end = (array.size() - 1);
        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (start <= end && super.ge(value,array.get(start)) && super.le(value,array.get(end))) {
            // Probing the position with keeping
            // uniform distribution in mind.
            int pos = start + (((end - start) / (array.get(end) - array.get(start))) * (value - array.get(start)));

            // Condition of target found
            if (super.eq(value,array.get(pos)))
                return pos;

            // If key is larger, key is in upper part
            if (super.lt(array.get(pos),value))
                start = pos + 1;
                // If key is smaller, x is in lower part
            else
                end = pos - 1;
        }
        return -1;
    }

    @Override
    public int find(Integer[] array, Integer value) {
        return this.find(new ArrayWrapper<Integer>(array),value);
    }
}
