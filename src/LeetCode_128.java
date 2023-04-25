import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x))
                continue;
            if (map.containsKey(x - 1) && map.containsKey(x + 1)) {
                int r1 = root(map, x - 1);
                int r2 = root(map, x + 1);
                map.put(x, r1);
                map.put(r2, r1);

            } else
            if (map.containsKey(x - 1)) {
                int root = root(map, x - 1);
                map.put(x, root);
            } else if (map.containsKey(x + 1)) {
                int root = root(map, x + 1);
                map.put(x, root);
            } else {
                map.put(x, x);
            }
        }
//        System.out.println(
//                map.entrySet().stream()
//                        .collect(Collectors.groupingBy(x -> root(map, x.getKey()))));
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(x -> root(map, x.getKey())))
                .values()
                .stream()
                .map(List::size)
                .max(Comparator.naturalOrder()).get();
    }

    private Integer root(HashMap<Integer, Integer> map, int k) {
        while (map.get(k) != k) {
            k = map.get(k);
        }
        return k;
    }

    @Test
    public void test1() {
        int[] arr = {100, 4, 200, 1, 3, 2};
        Assertions.assertEquals(4, longestConsecutive(arr));
    }

    @Test
    public void test2() {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Assertions.assertEquals(9, longestConsecutive(arr));
    }

    @Test
    public void test3() {
        int[] arr = {};
        Assertions.assertEquals(0, longestConsecutive(arr));
    }
}
