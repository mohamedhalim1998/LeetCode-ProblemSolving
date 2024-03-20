import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_399 {
    public static class Node implements Comparable<Node> {
        String to;
        double val;

        public Node(String to, double val) {
            this.to = to;
            this.val = val;
        }


        @Override
        public int compareTo(Node node) {
            return Double.compare(val, node.val);
        }
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var map = new HashMap<String, Integer>();
        var graph = new ArrayList<ArrayList<Node>>();
        int count = 0;
        for (int i = 0; i < equations.size(); i++) {
            var list = equations.get(i);
            map.put(list.get(0), map.getOrDefault(list.get(0), count++));
            var n1 = map.getOrDefault(list.get(0), -1);
            if (count >= graph.size()) {
                graph.add(new ArrayList<>());
            }
            graph.get(n1).add(new Node(list.get(1), values[i]));
            map.put(list.get(1), map.getOrDefault(list.get(1), count++));
            var n2 = map.getOrDefault(list.get(1), -1);
            if (count >= graph.size()) {
                graph.add(new ArrayList<>());
            }
            graph.get(n2).add(new Node(list.get(0), 1 / values[i]));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var query = queries.get(i);
            ans[i] = evalQuery(map, graph, query.get(0), query.get(1));
        }
        return ans;

    }

    private double evalQuery(HashMap<String, Integer> map, ArrayList<ArrayList<Node>> graph, String s, String e) {
        var visited = new HashSet<String>();
        var queue = new PriorityQueue<Node>();
        var res = new HashMap<String, Double>();
        if (map.containsKey(s)) {
            queue.add(new Node(s, 0));
            res.put(s, 1D);
        }
        while (!queue.isEmpty()) {
            var min = queue.poll();
            visited.add(min.to);
            for (var node : graph.get(map.get(min.to))) {
                if (!visited.contains(node.to)) {
                    queue.add(node);
                    res.put(node.to,
                            Math.min(res.getOrDefault(node.to, Double.POSITIVE_INFINITY), res.get(min.to) * node.val));
                }
            }
        }
        return res.getOrDefault(e, -1.0);
    }

    @Test
    public void  test_1() {
        System.out.println(Arrays.toString(calcEquation(List.of(List.of("a", "b"), List.of("b", "c")), new double[]{2.0, 3.0},
                List.of(List.of("a", "b"), List.of("b", "c"), List.of("a", "c")))));
    }

}
