import java.util.LinkedList;
import java.util.ArrayList;

// Custom HashMap implementation
public class Hashmap<K, V> {

    // ===============================
    // Inner class to represent a key-value pair
    // ===============================
    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // ===============================
    // Fields of the HashMap
    // ===============================
    private int n; // number of key-value pairs stored
    private int N; // number of buckets
    private LinkedList<Node>[] buckets; // array of linked lists

    // ===============================
    // Constructor
    // ===============================
    @SuppressWarnings("unchecked")
    public Hashmap() {
        this.N = 4; // initial capacity
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
        this.n = 0; // initially empty
    }

    // ===============================
    // Hash function → converts key into bucket index
    // ===============================
    private int hashFunction(K key) {
        int hashCode = key.hashCode(); // built-in hash
        return Math.abs(hashCode) % N; // ensure index is within bucket size
    }

    // ===============================
    // Search function → find index of key in a bucket
    // Returns index of node if key exists, else -1
    // ===============================
    private int searchInBucket(K key, int bucketIndex) {
        LinkedList<Node> bucket = buckets[bucketIndex];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return i; // found key
            }
        }
        return -1; // not found
    }

    // ===============================
    // PUT method → insert or update key-value pair
    // ===============================
    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex == -1) {
            // key not found → insert new node
            buckets[bucketIndex].add(new Node(key, value));
            n++;
        } else {
            // key found → update value
            Node node = buckets[bucketIndex].get(dataIndex);
            node.value = value;
        }

        // Check load factor
        double loadFactor = (double) n / N;
        if (loadFactor > 2.0) {
            rehash(); // expand size if too crowded
        }
    }

    // ===============================
    // GET method → return value for given key
    // ===============================
    public V get(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex != -1) {
            return buckets[bucketIndex].get(dataIndex).value;
        }
        return null; // key not found
    }

    // ===============================
    // CONTAINS KEY method
    // ===============================
    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);
        return dataIndex != -1;
    }

    // ===============================
    // REMOVE method → remove key-value pair
    // ===============================
    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex != -1) {
            Node node = buckets[bucketIndex].remove(dataIndex);
            n--;
            return node.value;
        }
        return null; // key not found
    }

    // ===============================
    // KEYSET method → return all keys in ArrayList
    // ===============================
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            LinkedList<Node> bucket = buckets[i];
            for (Node node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    // ===============================
    // ISEMPTY method
    // ===============================
    public boolean isEmpty() {
        return n == 0;
    }

    // ===============================
    // REHASH method → expand bucket size and re-insert all keys
    // ===============================
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        N = N * 2; // double the bucket size
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        n = 0; // reset count
        for (LinkedList<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value); // reinsert into new buckets
            }
        }
    }
}
