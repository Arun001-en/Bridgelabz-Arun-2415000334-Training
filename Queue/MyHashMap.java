import java.util.*;

class MyHashMap<K, V> {
    private final int SIZE = 10;
    private LinkedList<Entry<K, V>>[] table;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }
}