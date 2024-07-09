import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class LeetCode_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0, j = costs.length - 1;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        while (i <= j && i < candidates) {
            queue.add(new Node(i, costs[i], true));
            if(i != j) {
                queue.add(new Node(j, costs[j], false));
                j--;
            }
            i++;
        }
        long total = 0;
        while (k-- > 0) {
            var node = queue.poll();
            total += node.val;
            if (i > j) {
                continue;
            }
            if (node.start) {
                queue.add(new Node(i, costs[i++], true));

            } else {
                queue.add(new Node(j, costs[j--], false));

            }
        }
        return total;
    }

    public static class Node implements Comparable<Node> {
        int index, val;
        boolean start;

        public Node(int index, int val, boolean start) {
            this.index = index;
            this.val = val;
            this.start = start;
        }

        @Override
        public int compareTo(Node node) {
            if (node.val == val) {
                return Integer.compare(index, node.index);
            }
            return Integer.compare(val, node.val);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", val=" + val +
                    ", start=" + start +
                    '}';
        }
    }

    @Test
    public void test() {
        totalCost(new int[]{48}, 1, 1);
    }
}
