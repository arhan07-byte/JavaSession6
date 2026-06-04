import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

public class LruCache {
    private int size;
    private Deque<Integer> deq = new LinkedList<>();
    private Hashtable<Integer, Integer> tab = new Hashtable<>();

    public LruCache(int cap) {
        this.size = cap;
    }

    public void put(int key, int value) {
        if (tab.containsKey(key)) {
            deq.remove(key);
            tab.put(key, value);
            deq.offerFirst(key);
            System.out.println(tab);
            return;
        }

        if (deq.size() == size) {
            int exists = deq.pollLast();
            tab.remove(exists);
            System.out.println("LRU key was " + exists +
                    ", evicts key, cache is " + tab);
        }

        tab.put(key, value);
        deq.offerFirst(key);
        System.out.println(tab);
    }

    public int get(int key) {
        if (tab.containsKey(key)) {
            deq.remove(key);
            deq.offerFirst(key);
            return tab.get(key);
        }
        return -1;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);

        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}