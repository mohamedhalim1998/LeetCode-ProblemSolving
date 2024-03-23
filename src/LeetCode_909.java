import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_909 {
    public int snakesAndLadders(int[][] board) {
        int start = 0;
        return bfs(start, board);
    }

    private int bfs(int start, int[][] board) {
        var queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        res.put(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited.contains(curr))
                continue;
            visited.add(curr);
         //    System.out.println(curr);
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if(next >= board.length * board.length) {
                    continue;
                }
                int[] point = to2D(next, board.length);
             //   System.out.printf("converting : %d  to %s \n",next, Arrays.toString(point));
                if (board[board.length - 1 - point[0]][point[1]] != -1) {
                    next = board[board.length - 1 - point[0]][point[1]] - 1;
                }
                if(!visited.contains(next)) {
                    queue.add(next);
                    res.put(next, Math.min(res.getOrDefault(next, Integer.MAX_VALUE), res.get(curr) + 1));
                }
            }

        }
        return res.getOrDefault(board.length * board.length - 1, -1);
    }

    private int[] to2D(int i, int len) {
        boolean odd = (i / len) % 2 == 1;
        return odd ? new int[]{i / len, len - 1 - (i % len)} : new int[]{i / len, i % len};
    }

    @Test
    public void test1() {
        int[][] data = {
                {-1, -1, -1, -1, 48, 5, -1},
                {12, 29, 13, 9, -1, 2, 32},
                {-1, -1, 21, 7, -1, 12, 49},
                {42, 37, 21, 40, -1, 22, 12},
                {42, -1, 2, -1, -1, -1, 6},
                {39, -1, 35, -1, -1, 39, -1},
                {-1, 36, -1, -1, -1, -1, 5}
        };
        System.out.println("RES:" + snakesAndLadders(data));
    }
}
