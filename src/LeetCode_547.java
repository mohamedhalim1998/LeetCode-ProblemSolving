import org.junit.jupiter.api.Test;

public class LeetCode_547 {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int curr, int[][] isConnected, boolean[] visited) {
        if(visited[curr]) {
            return;
        }
        visited[curr] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[curr][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }

    @Test
    public void test1() {
        int[][] array = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        findCircleNum(array);
    }
}
