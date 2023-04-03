import java.util.*;

public class LeetCode_815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int x : route) {
                ArrayList<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(i);
                map.put(x, list);
            }
        }
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            graph.add(new HashSet<>());
        }
        for (ArrayList<Integer> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    graph.get(list.get(i)).add(list.get(j));
                    graph.get(list.get(j)).add(list.get(i));
                }
            }
        }
        int[] path = new int[routes.length];
        Arrays.fill(path, Integer.MAX_VALUE);
        HashSet<Integer> s = new HashSet<>(map.getOrDefault(source, new ArrayList<>()));
        HashSet<Integer> t = new HashSet<>(map.getOrDefault(target, new ArrayList<>()));
        Queue<Integer> queue = new LinkedList<>();
        for (int x : s) {
            path[x] = 1;
            queue.add(x);
        }
        boolean[] visited = new boolean[routes.length];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr])
                continue;
            visited[curr] = true;
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    path[x] = Math.min(path[x], path[curr] + 1);
                    queue.add(x);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : t) {
            min = Math.min(min, path[x]);
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
