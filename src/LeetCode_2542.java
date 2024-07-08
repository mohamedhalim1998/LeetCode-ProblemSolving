import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;


public class LeetCode_2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        long sum = 0;

        Pair[] A = new Pair[nums1.length];
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; ++i)
            A[i] = new Pair(nums2[i], nums1[i]);

        Arrays.sort(A, (a, b) -> Integer.compare(b.x, a.x));

        for (Pair a : A) {
            final int num2 = a.x;
            final int num1 = a.y;
            minHeap.offer(num1);
            sum += num1;
            if (minHeap.size() > k)
                sum -= minHeap.poll();
            if (minHeap.size() == k)
                ans = Math.max(ans, sum * num2);
        }

        return ans;
    }



    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Node implements Comparable<Node> {
        int val, index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }


        @Override
        public int compareTo(Node node) {
            return Integer.compare(node.val, val);
        }

    }

    @Test
    public void test1() {
        int[] num1 = {2,1,14,12};
        int[] num2 = {11,7,13,6};
        System.out.println(maxScore(num1, num2, 3));

    }
}
