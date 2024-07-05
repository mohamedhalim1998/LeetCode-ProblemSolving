import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class LeetCode_1466 {
    public int minReorder(int n, int[][] connections) {
        var graph = new ArrayList<ArrayList<Integer>>();
        var revGraph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for (var node : connections) {
            graph.get(node[0]).add(node[1]);
            revGraph.get(node[1]).add(node[0]);
        }

        int res = dfs(graph, revGraph);

        return res;
    }

    private int dfs(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> revGraph) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int res = 0;
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (var i : revGraph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.add(i);
                }
            }
            for (var i : graph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    res++;
                    stack.add(i);
                }
            }
        }

        return res;
    }

    private int dfs(HashSet<Integer> reached, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(reached);
        int count = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (var i : graph.get(curr)) {
                if (!reached.contains(i)) {
                    stack.add(i);
                    reached.add(i);
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int[][] array = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };
        System.out.println(minReorder(6, array));
    }
}
