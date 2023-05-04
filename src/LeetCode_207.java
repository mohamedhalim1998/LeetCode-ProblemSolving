import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        return !hasCycle(graph);
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
}
