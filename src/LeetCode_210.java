import java.util.*;

public class LeetCode_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dep = new int[numCourses];
        for (int[] arr : prerequisites) {
            int x = arr[0];
            int y = arr[1];
            graph.get(x).add(y);
            dep[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dep.length; i++) {
            if (dep[i] == 0) {
                queue.add(i);
            }
        }
        if (hasCycle(graph)) {
            return new int[]{};
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if(!visited[i])
                DFS(i, visited, graph, stack);
        }
        int[] ans = new int[stack.size()];
        int i = numCourses - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }

    private void DFS(int v, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> ans) {
        visited[v] = true;
        for (int x : graph.get(v)) {
            if (!visited[x])
                DFS(x,visited, graph, ans);
        }
        ans.push(v);
    }

    private boolean DFS(int v, HashSet<Integer> visited, HashSet<Integer> currentPath, ArrayList<ArrayList<Integer>> graph) {
        visited.add(v);
        currentPath.add(v);

        for (int neighbor : graph.get(v)) {
            if (!visited.contains(neighbor) && DFS(neighbor, visited, currentPath, graph))
                return true;
            else if (currentPath.contains(neighbor))
                return true;
        }

        currentPath.remove(v);
        return false;
    }


    private boolean hasCycle(ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> currentPath = new HashSet<>();

        for (int v = 0; v < graph.size(); ++v) {
            if (!visited.contains(v) && DFS(v, visited, currentPath, graph))
                return true;
        }

        return false;
    }

}
