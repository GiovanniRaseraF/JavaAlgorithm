package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class SimpleSort<T extends Comparable<T>> extends SortAlgorithm<T> {


    @Override
    public void sort(T[] array, Direction dir) throws NullPointerException, ClassCastException {
        this.sort(new ArrayWrapper<T>(array),dir);
    }

    @Override
    public void sort(List<T> array, Direction dir) throws NullPointerException, ClassCastException {
        super.sort(array,dir);
        BiPredicate<T,T> comparingDirection = null;
        switch(dir){
            case CRESCENTE:
                comparingDirection = (a,b) -> {return a.compareTo(b) > 0;};
                break;
            case DECRESCIENTE:
                comparingDirection = (a,b) -> {return a.compareTo(b) < 0;};
                break;
        }
        this.sortIt(array, comparingDirection);
    }

    /**
     * EFFECTS: Ordina la lista dinamica secondo la specifica di comparingDirecrtion
     * utilizzando simple sort
     * @param array
     * @param comparingDirection
     */
    private void sortIt(List<T> array, BiPredicate comparingDirection){
        int lenght = array.size();
        for(int i = 0; i<lenght-1;i++){
            for(int j = i+1;j<lenght;j++){
                if(comparingDirection.test(array.get(i),array.get(j))){
                    super.swap(array,i,j);
                }
            }
        }
    }
}
