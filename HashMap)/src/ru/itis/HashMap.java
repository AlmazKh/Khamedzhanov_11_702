package ru.itis;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class HashMap<K extends Comparable<K>, V extends Comparable<V>> implements Map<K, V>{
    private LinkedList<K, V> []list;
    private static final int COUNT = 16;

    public HashMap() {
        this.list = new LinkedList[COUNT];
    }

    public int hash(K key) {
        int code = Math.abs(key.hashCode() % 10);
        return code;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if(list[index] == null) {
            list[index] = new LinkedList<>();
            list[index].add(key, value);
        } else {
            for (int i = 0; i < list[index].size(); i++) {
                if (list[index].get(i).key.hashCode() == key.hashCode() && (list[index].get(i).key.equals(key))) {
                    list[index].replace(i, key, value);
                    return;
                }
            }
            list[index].add(key,value);
        }
    }

    public V get(K key) {
        int index = hash(key);
        if (list[index].size() == 1){
            return list[index].get(0).value;
        }
        for (int i = 0; i < list[index].size(); i++){
            if (list[index].get(i).key.hashCode() == key.hashCode() && (list[index].get(i).key.equals(key))){
                return list[index].get(i).value;
            }
        }
        throw new IllegalArgumentException();
    }
}
