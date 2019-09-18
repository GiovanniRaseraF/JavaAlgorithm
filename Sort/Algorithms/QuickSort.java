package JavaAlgorithm.Sort.Algorithms;

import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;
import java.util.function.BiPredicate;

public class QuickSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(List<T> array, Direction dir) throws NullPointerException, ClassCastException {
        super.sort(array, dir);
        BiPredicate<T,T> can_h = null,can_l = null;
        switch(dir) {
            case CRESCENTE:
                can_h = (a,b)->{return a.compareTo(b) > 0;};
                can_l = (a,b)->{return a.compareTo(b) < 0;};
                break;
            case DECRESCIENTE:
                can_h = (a,b)->{return a.compareTo(b) < 0;};
                can_l = (a,b)->{return a.compareTo(b) > 0;};
                break;
        }
        quickSort(array,0,array.size()-1,can_h,can_l);
    }

    /**
     * MODIFIES: array
     * EFFECTS: ordina a[low], a[low+1],...,a[high] secondo le specifiche di can_h e can_l
     * @param array != null
     * @param low 0 <= low
     * @param high high < a.length
     * @param can_h != null
     * @param can_l != null
     */
    private void quickSort(List<T> array,int low, int high, BiPredicate<T,T> can_h,BiPredicate can_l) {
        if(low >= high) return;
        int mid = partition(array, low, high,can_h,can_l);
        quickSort(array,low,mid,can_h,can_l);
        quickSort(array,mid+1,high,can_h,can_l);
    }

    /**
     * EFFETTO: Riordina gli elementi i due gruppi continui a[i],...,a[res]
     * and a[res+1],...,a[j], cosi che ogni elemento del secondo gruppo sia almeno grande come
     * ogni elemento del primo gruppo
     *
     * MODIFIES: array
     * @param array != null
     * @param i 0 <= i < j < array.length
     * @param j  i < j < array.lenth
     * @param can_h != null
     * @param can_l != null
     * @return
     */
    private int partition(List<T> array, int i, int j, BiPredicate<T,T> can_h,BiPredicate can_l) {
        T x = array.get(i);
        while(true) {
            while(can_h.test(array.get(j),x)) {
                j--;
            }
            while(can_l.test(array.get(i),x)) {
                i++;
            }
            if(i < j) {
                super.swap(array,i,j);
                j--;
                i++;
            }else {
                return j;
            }
        }
    }

    @Override
    public void sort(T[] array, Direction dir) throws NullPointerException, ClassCastException {
        this.sort(new ArrayWrapper<T>(array),dir);
    }
}
