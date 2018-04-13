package ru.itis;

public interface Map <K extends Comparable<K>, V extends Comparable<V>> {
    int hash(K key);
    void put(K key, V value);
    V get(K key);
}
