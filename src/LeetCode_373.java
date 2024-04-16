import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize heap with first k elements from nums1
        for (int i = 0; i < k && i < nums1.length; i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!minHeap.isEmpty() && k > 0) {
            int[] currentPair = minHeap.poll();
            int sum = currentPair[0];
            int i = currentPair[1];
            int j = currentPair[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Explore next element in nums2 for the same i
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }

    static class Sum implements Comparable<Sum> {
        int i;
        int j;
        int sum;

        public Sum(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public int compareTo(Sum sum) {
            return Integer.compare(this.sum, sum.sum);
        }
    }

    @Test
    public void test1() {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{5,6,7,8};
        System.out.println(kSmallestPairs(a, b, 20));
    }
}
