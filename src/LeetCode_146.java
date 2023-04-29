import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LeetCode_146 {
    class LRUCache {
        private HashMap<Integer, Integer> map = new HashMap<>();
        private LinkedHashSet<Integer> set = new LinkedHashSet<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                set.remove(key);
                set.add(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.size() >= capacity && !map.containsKey(key)) {
                int removed = set.stream().findFirst().get();
                set.remove(removed);
                map.remove(removed);
            }
            set.remove(key);
            set.add(key);
            map.put(key, value);
        }
    }

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(4, 4);
    }
}
