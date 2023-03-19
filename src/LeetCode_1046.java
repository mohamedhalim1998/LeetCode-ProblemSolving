import java.util.PriorityQueue;

public class LeetCode_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : stones) {
            queue.add(-x);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                queue.add(-Math.abs(x - y));
            }
        }
        return queue.size() == 1 ? queue.peek() : 0;
    }
}
