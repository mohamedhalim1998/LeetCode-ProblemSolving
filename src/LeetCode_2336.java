import java.util.HashSet;
import java.util.PriorityQueue;

public class LeetCode_2336 {
    class SmallestInfiniteSet {
        private final PriorityQueue<Integer> queue;
        private final HashSet<Integer> set;

        public SmallestInfiniteSet() {
            queue = new PriorityQueue<>();
            set = new HashSet<>();
            for (int i = 1; i <= 1000; i++) {
                queue.add(i);
                set.add(i);
            }
        }

        public int popSmallest() {
            int x = queue.remove();
            set.remove(x);
            return x;
        }

        public void addBack(int num) {
            if(!set.contains(num)) {
                queue.add(num);
                set.add(num);
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
