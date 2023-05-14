import java.util.*;

public class LeetCode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        priorityQueue.addAll(map.entrySet());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = priorityQueue.poll().getKey();
        }
        return arr;
    }
}
