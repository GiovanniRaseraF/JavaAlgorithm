package JavaAlgorithm.Sort;


import JavaAlgorithm.Sort.Algorithms.*;
import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class Sorter {

    /**
     * OVERVIEW: Algoritmi disponibili
     */
    public static enum Algorithm {
        SIMPLE,QUICK,BUBBLESORT,BOGO,CLOCKTAILSHAKER,COMB,GNOME,INSERTION,PANCAKE,SELECTION,SHELL
    }

    /**
     * REQUIRE: array != null, dir != null, sorter != null
     * EFFECTS: Riordina l'assray in base alle specifiche che vengono fornite
     * MODIFIES: array
     * @param array     array che verrà ordinato
     * @param dir       direzione di ordinamento CRESCENTE o DECRESCENTE
     * @param sorter    Tipo di algoritmo che si vuole utilizzare
     */
    public static <T extends Comparable<T>> void sort(List<T> array, SortAlgorithm.Direction dir, Algorithm sorter){
        SortAlgorithm<T> sortingAlgorithm = null;
        switch (sorter){
            case SIMPLE:
                sortingAlgorithm = new SimpleSort<T>();
                break;
            case QUICK:
                sortingAlgorithm = new QuickSort<T>();
                break;
            case BUBBLESORT:
                sortingAlgorithm = new BubbleSort<T>();
                break;
            case BOGO:
                sortingAlgorithm = new BogoSort<T>();
                break;
            case CLOCKTAILSHAKER:
                sortingAlgorithm = new CocktailShakerSort<T>();
                break;
            case COMB:
                sortingAlgorithm = new CombSort<T>();
                break;
            case GNOME:
                sortingAlgorithm = new GnomeSort<T>();
                break;
            case INSERTION:
                sortingAlgorithm = new InsertionSort<T>();
                break;
            case PANCAKE:
                sortingAlgorithm = new PancakeSort<T>();
                break;
            case SELECTION:
                sortingAlgorithm = new SelectionSort<T>();
                break;
            case SHELL:
                sortingAlgorithm = new ShellSort<T>();
                break;

        }
        sortingAlgorithm.sort(array,dir);
    }

    public static <T extends Comparable<T>> void sort(T[] array, SortAlgorithm.Direction dir, Algorithm sorter){
        sort(new ArrayWrapper<T>(array),dir,sorter);
    }
}
