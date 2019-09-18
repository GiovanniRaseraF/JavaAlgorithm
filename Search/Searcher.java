package JavaAlgorithm.Search;

import JavaAlgorithm.Search.Algorithms.*;
import JavaAlgorithm.Tools.ArrayWrapper;

import java.util.List;

public class Searcher {

    /**
     * OVERVIEW: Algoritmi disponibili per la ricerca
     */
    public static enum Algorithm{
        LINEAR,BINARY,INTERPOLATION,ITERATIVEBINARY,TERNARY,ITERATIVETERNARY
    }

    public static <T extends Comparable<T>> int find(List<T> array, T value, Algorithm algorithm){
        SearchAlgorithm<T> searchAlgorithm = null;
        switch (algorithm){
            case LINEAR:
                searchAlgorithm = new LinearSearch<T>();
                break;
            case BINARY:
                searchAlgorithm = new BinarySearch<T>();
                break;
            case INTERPOLATION:
                searchAlgorithm = new BinarySearch<T>();
                break;
            case ITERATIVEBINARY:
                searchAlgorithm = new BinarySearch<T>();
                break;
            case TERNARY:
                searchAlgorithm = new TernarySearch<T>();
                break;
            case ITERATIVETERNARY:
                searchAlgorithm = new IterativeTernarySearch<>();
                break;
        }
        return searchAlgorithm.find(array,value);
    }
    public static <T extends Comparable<T>> int find(T[] array, T value, Algorithm algorithm){
        return find(new ArrayWrapper<T>(array),value,algorithm);
    }


}
