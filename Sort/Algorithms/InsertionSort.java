package JavaAlgorithm.Sort.Algorithms;

import java.util.List;
import java.util.function.BiPredicate;

public class InsertionSort<T extends Comparable<T>> extends SortAlgorithm<T>{


    @Override
    public void sort(T[] array, Direction dir) throws NullPointerException, ClassCastException {
        super.sort(array, dir);
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

    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        for (int j = 1; j < array.size(); j++) {
            // Picking up the key(Card)
            T key = array.get(j);
            int i = j - 1;
            while (i >= 0 && comparingDirection.test(key, array.get(i))) {
                array.set(i + 1, array.get(i));
                i--;
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            array.set(i + 1, key);
        }
    }
}
