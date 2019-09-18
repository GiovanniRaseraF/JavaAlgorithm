package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;

public class BogoSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    private static final Random random = new Random();

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
                comparingDirection = (a,b) -> {return a.compareTo(b) <= 0;};
                break;
            case DECRESCIENTE:
                comparingDirection = (a,b) -> {return a.compareTo(b) >= 0;};
                break;
        }
        this.sortIt(array, comparingDirection);
    }

    /**
     * EFFECTS: Ordina array utilizzado BogoSort
     * MODIFIES: array
     * @param array
     * @param direction
     */
    public void sortIt(List<T> array, BiPredicate<T,T> direction) {
        while (!this.isSorted(array,direction)) {
            this.nextPermutation(array);
        }
    }

    /**
     * EFFECTS: Scambia i valori nella struttura in modo casuale
     * MODIFES: this
     * @param array
     */
    private void nextPermutation(List<T> array) {
        int length = array.size();
        for (int i = 0; i < length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            super.swap(array, randomIndex, i);
        }
    }

    /**
     * EFFECTS: Ritorna true se la lista è ordinata e false se non lo è
     * @param array
     * @param direction
     * @return
     */
    private boolean isSorted(List<T> array, BiPredicate<T,T> direction) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (direction.test(array.get(i + 1), array.get(i))) return false;
        }
        return true;
    }

}
