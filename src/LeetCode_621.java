import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        PriorityQueue<Item> queue = new PriorityQueue<>((item1, item2) -> Integer.compare(item2.freq, item1.freq));
        for (int i = 0; i < 26; i++) {
            if(arr[i] > 0)
            queue.add(new Item((char) ('A' + i), arr[i], -n - 1));
        }
        int count = 0;
        int time = 1;
        while (count < tasks.length) {
            ArrayList<Item> reAdd = new ArrayList<>();
            Item item = queue.poll();
            while (!queue.isEmpty() && item.freq > 0 && item.last + n >= time) {
                reAdd.add(item);
                item = queue.poll();
            }
            if (item != null && item.freq > 0 && item.last + n < time) {
                item.freq -= 1;
                item.last = time;
                count++;
            }
            if(item != null)
                queue.add(item);
            queue.addAll(reAdd);
            time++;
        }
        return time - 1;
    }

    class Item {
        char c;
        int freq;
        int last;

        public Item(char c, int freq, int last) {
            this.c = c;
            this.freq = freq;
            this.last = last;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "c=" + c +
                    ", freq=" + freq +
                    ", last=" + last +
                    '}';
        }
    }

    @Test
    public void test_1() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        Assertions.assertEquals(8, leastInterval(tasks, n));
    }
    @Test
    public void test_4() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 50;
        Assertions.assertEquals(104, leastInterval(tasks, n));
    }
    @Test
    public void test_2() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;
        Assertions.assertEquals(6, leastInterval(tasks, n));
    }
    @Test
    public void test_3() {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        Assertions.assertEquals(16, leastInterval(tasks, n));
    }
}
