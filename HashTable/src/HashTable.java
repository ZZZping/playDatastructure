import java.nio.charset.IllegalCharsetNameException;
import java.util.TreeMap;

public class HashTable<K, V> {

//    private final int[] capacity
//            = {};

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    //记录所取的素数
    private int M;
    private int size;
    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i ++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(initCapacity);
    }

    /**
     * hash函数
     * @param key hash表中待传入数据
     * @return 返回处理后的值
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size ++;
            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size --;
            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " does not exist");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] hashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i ++) {
            hashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i ++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                hashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashtable = hashTable;
    }

}
