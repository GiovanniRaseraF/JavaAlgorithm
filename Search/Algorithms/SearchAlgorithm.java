package JavaAlgorithm.Search.Algorithms;

import java.util.List;

public abstract class SearchAlgorithm<T extends Comparable<T>> {

    /**
     * EFFECTS: Ritorna il valore dell'indice in cui T è salvato
     * Se il value non è all'interno della struttura viene ritornato -1
     * @param array
     * @param value
     * @return
     */
    public abstract int find(List<T> array, T value);
    public abstract int find(T[] array, T value);

    /**
     * EFFECTS: True se i due valori sono uguali
     * False se i due valori non sono uguali
     * @param a
     * @param b
     * @return
     */
    public boolean eq(T a, T b){
        return a.compareTo(b) == 0;
    }

    /**
     * EFFECTS: LT sta per lessThen
     * True se a minore di b , false altrimenti
     * @param a
     * @param b
     * @return
     */
    public boolean lt(T a, T b){
        return a.compareTo(b) < 0;
    }

    /**
     * EFFECTS: GT sta per GreaterThen
     * True se a maggiore di b , false altrimenti
     * @param a
     * @param b
     * @return
     */
    public boolean gt(T a, T b){
        return a.compareTo(b) > 0;
    }

    /**
     * EFFECTS: LE sta per lessEqual
     * True se a minore o uguale di b , false altrimenti
     * @param a
     * @param b
     * @return
     */
    public boolean le(T a, T b){
        return a.compareTo(b) <= 0;
    }

    /**
     * EFFECTS: GE sta per GreaterEqual
     * True se a maggiore o uguale di b , false altrimenti
     * @param a
     * @param b
     * @return
     */
    public boolean ge(T a, T b){
        return a.compareTo(b) >= 0;
    }
}
