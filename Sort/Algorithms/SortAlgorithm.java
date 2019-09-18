package JavaAlgorithm.Sort.Algorithms;

import java.util.List;

public abstract class SortAlgorithm<T extends Comparable<T>> {

    /**
     * Direzione in cui deve essere ordinato il set
     */
    public enum Direction{
        CRESCENTE,DECRESCIENTE
    }

    /**
     * Ordina array puri che non sono strutture di namiche
     * @param array
     * @param dir
     * @throws NullPointerException se dir o array sono null
     * @throws ClassCastException se nell'array ci sono due elementi non comparabili
     */
    public void sort(T[] array, Direction dir)throws NullPointerException, ClassCastException{
        if(array == null || dir == null) throw new NullPointerException("Sort.sort : : Array e dir non devono essere null");
    }

    /**
     * Ordina strutture dinamiche: sottroclassi di List
     * @param array
     * @param dir
     * @throws NullPointerException se dir o array sono null
     * @throws ClassCastException se nell'array ci sono due elementi non comparabili
     */
    public void sort(List<T> array, Direction dir)throws NullPointerException,ClassCastException{
        if(array == null || dir == null) throw new NullPointerException("Sort.sort : : Array e dir non devono essere null");
    }

    /**
     * Scambia il valore nell'array alla posizione i con quello alla posizionme j
     * @param array
     * @param i
     * @param j
     */
    protected void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * Scambia il valore nell'array alla posizione i con quello alla posizionme j
     * @param array
     * @param i
     * @param j
     */
    protected void swap(List<T> array, int i, int j){
        T temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }
}
