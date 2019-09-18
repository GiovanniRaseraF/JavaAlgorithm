package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    @Override
    public void sort(T[] array, Direction dir) throws NullPointerException, ClassCastException {
        this.sort(new ArrayWrapper<T>(array),dir);
    }

    @Override
    public void sort(List<T> array, Direction dir) throws NullPointerException, ClassCastException {
        super.sort(array, dir);
        BiPredicate<T,T> comparingDirection = null;
        switch(dir){
            case CRESCENTE:
                comparingDirection = (a,b) -> {return a.compareTo(b) < 0;};
                break;
            case DECRESCIENTE:
                comparingDirection = (a,b) -> {return a.compareTo(b) > 0;};
                break;
        }
        this.sortIt(array, comparingDirection);
    }

    /**
     * EFFECTS: Riordina l'array utilizzando SelectionSort
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        int size = array.size();
        for (int i = 0; i < size - 1; i++) {
            // Initial index of min
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (comparingDirection.test(array.get(j), array.get(min))) {
                    min = j;
                }
            }
            // Swapping if index of min is changed
            if (min != i) {
                super.swap(array, i, min);
            }
        }
    }
}
