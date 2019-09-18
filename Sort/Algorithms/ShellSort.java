package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class ShellSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    @Override
    public void sort(T[] array, Direction dir) throws NullPointerException, ClassCastException {
        this.sort(new ArrayWrapper<T>(array), dir);
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
     * EFFECTS: Riordina la struttura utilizzando ShellSort
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        int lenght = array.size();
        int high = 1;
        while (high < lenght / 3) {
            high = 3 * high + 1;
        }
        while (high >= 1) {
            for (int i = high; i < lenght; i++) {
                for (int j = i; j >= high && comparingDirection.test(array.get(j), array.get(j - high)); j -= high) {
                    swap(array, j, j - high);
                }
            }

            high /= 3;
        }

    }


}
