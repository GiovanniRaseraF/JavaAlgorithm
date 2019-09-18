package JavaAlgorithm.Search.Algorithms;

import java.util.List;

public class LinearSearch<T extends Comparable<T>> extends SearchAlgorithm<T> {
    /**
     * IMPORTANTE: Non serve che il vettore sia ordinato al fine di trovare la posizione di un elemento
     * L'algoritmo è estremamente in'efficiente se sono presenti molti elemente
     * Se il vettore è ordinato conviene utilizzare BINARY come algoritmo di ricerca
     * EFFECTS: Ritorna la posizione in qui value è salvato in array
     * se value non è in array allora ritorna -1
     * @param array
     * @param value
     * @return
     * @throws NullPointerException
     */
    @Override
    public int find(List<T> array, T value) throws NullPointerException{
        if(array == null || value == null) throw new NullPointerException("Search.Linear : : array e valore non possono essere null");
        return this.findIt(array,value);
    }

    /**
     * REQUIRE: array != null, value != null
     * EFFECTS: Ritorna la posizione in qui è value all'interno di array
     * se value non è nell'array ritorna -1
     * @param array
     * @param value
     * @return
     */
    private int findIt(List<T> array,T value){
        int length = array.size();
        for(int i = 0; i < length; i++){
            if(super.eq(array.get(i),value)) return i;
        }
        return -1;
    }

    @Override
    public int find(T[] array, T value) {
        return 0;
    }
}
