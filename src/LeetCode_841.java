import java.util.LinkedList;
import java.util.List;

public class LeetCode_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if(visited[curr]) {
                continue;
            }
            visited[curr] = true;
            for(var i : rooms.get(curr)) {
                if(!visited[i]) {
                    queue.add(i);
                }
            }
        }
        for(var b : visited) {
            if(!b) {
                return false;
            }
        }
        return true;
    }
}
