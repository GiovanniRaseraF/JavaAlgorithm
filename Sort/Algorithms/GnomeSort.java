package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class GnomeSort<T extends Comparable<T>> extends SortAlgorithm<T> {

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
     * EFFECTS: Riordina l'array utilizzando GnomeSort
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        int i = 1;
        int j = 2;
        while (i < array.size()) {
            if (comparingDirection.test(array.get(i - 1), array.get(i))) i = j++;
            else {
                super.swap(array, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }
    }
}
