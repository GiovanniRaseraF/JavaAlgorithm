package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class PancakeSort<T extends Comparable<T>> extends SortAlgorithm<T> {
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

    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirecion){
        int size = array.size();
        for (int i = 0; i < size; i++) {
            T max = array.get(0);
            int index = 0;
            for (int j = 0; j < size - i; j++) {
                if (comparingDirecion.test(max, array.get(j))) {
                    max = array.get(j);
                    index = j;
                }
            }
            this.flip(array, index, size - 1 - i);
        }
    }

    /**
     * EFFECTS: Scambia tutte le posizioni da lest a right dell'array
     * MODIFIES: array
     * @param array is an array
     * @param left  is a left flip border of the array
     * @param right is a right flip border of the array
     */
    private void flip(List<T> array, int left, int right) {
        while (left <= right) {
            super.swap(array, left++, right--);
        }
    }
}
