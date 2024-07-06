import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int min = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        int[][] visited = new int[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            if (isExist(curr, maze.length, maze[0].length) && curr != entrance) {
                min = Math.min(min, visited[curr[0]][curr[1]]);
            }
            List<int[]> moves = move(curr, maze.length, maze[0].length);
            for (var move : moves) {
                if (visited[move[0]][move[1]] == 0 && maze[move[0]][move[1]] == '.') {
                    visited[move[0]][move[1]] = visited[curr[0]][curr[1]] + 1;
                    queue.add(move);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isExist(int[] curr, int m, int n) {
        if (curr[0] == 0) {
            return true;
        }
        if (curr[0] == n - 1) {
            return true;
        }
        if (curr[1] == 0) {
            return true;
        }
        if (curr[1] == m - 1) {
            return true;
        }
        return false;
    }

    private List<int[]> move(int[] curr, int m, int n) {
        var list = new ArrayList<int[]>();
        if (curr[0] > 0) {
            list.add(new int[]{curr[0] - 1, curr[1]});
        }
        if (curr[0] < n - 1) {
            list.add(new int[]{curr[0] + 1, curr[1]});
        }
        if (curr[1] > 0) {
            list.add(new int[]{curr[0], curr[1] - 1});
        }
        if (curr[1] < m - 1) {
            list.add(new int[]{curr[0], curr[1] + 1});
        }
        return list;
    }
    @Test
    public void test(){
        char[][] grid = {
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '.', '.', '+'},
                {'+', '+', '+', '+', '.', '+', '.'}
        };

        nearestExit(grid, new int[]{1,2});
    }
}
