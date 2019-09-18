package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class CombSort<T extends Comparable<T>> extends SortAlgorithm<T> {

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
     * EFFECTS: Ordina l'array secondo la direzione specificata
     * MODIFIES: array
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        int size = array.size();
        // initialize gap
        int gap = size;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            // Find next gap
            gap = nextGap(gap);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < size - gap; i++) {
                if (comparingDirection.test(array.get(i + gap), array.get(i))) {
                    // Swap arr[i] and arr[i+gap]
                    super.swap(array, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    /**
     * EFFECTS: Trova il gab tra gli elementi
     * @param gap
     * @return
     */
    private int nextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        return (gap < 1) ? 1 : gap;
    }
}
