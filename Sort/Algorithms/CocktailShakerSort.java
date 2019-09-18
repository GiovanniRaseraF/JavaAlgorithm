package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class CocktailShakerSort<T extends Comparable<T>> extends SortAlgorithm<T>{



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
     * EFFECTS: Ordina la lista nell'ordine specificato
     * MODIFIES: array
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate<T,T> comparingDirection){
        int length = array.size();
        int left = 0;
        int right = length - 1;
        int swappedLeft, swappedRight;

        while (left < right) {
            //Davanti
            swappedRight = 0;
            for (int i = left; i < right; i++) {
                if (comparingDirection.test(array.get(i + 1), array.get(i))){
                    super.swap(array, i, i + 1);
                    swappedRight = i;
                }
            }
            //Dietro
            right = swappedRight;
            swappedLeft = length - 1;
            for (int j = right; j > left; j--) {
                if (comparingDirection.test(array.get(j), array.get(j - 1))) {
                    super.swap(array, j - 1, j);
                    swappedLeft = j;
                }
            }
            left = swappedLeft;
        }
    }
}
