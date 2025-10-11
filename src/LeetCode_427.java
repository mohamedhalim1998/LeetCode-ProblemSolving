import org.junit.Test;

public class LeetCode_427 {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return buildTreePart(grid, Pair.of(0, 0), Pair.of(n , n));
    }

    private Node buildTreePart(int[][] grid, Pair start, Pair end) {
        var change = false;
        var val = grid[start.y][start.x];
        System.out.println("Start: " +  start);
        System.out.println("END: " +  end);
        L1:
        for (int i = start.y; i < end.y; i++) {
            for (int j = start.x; j < end.x; j++) {
                if (val != grid[i][j]) {
                    change = true;
                    break L1;
                }
            }
        }
        var node = new Node();
        if (!change) {
            node.val = val == 1;
            node.isLeaf = true;
            System.out.println("VAL: " + val);
            return node;
        }
        node.val = true;

        node.topLeft = buildTreePart(grid, Pair.of(start.x, start.y), Pair.of(start.x + (end.x - start.x) / 2, start.y + (end.y - start.y) / 2));
        node.topRight = buildTreePart(grid, Pair.of(start.x + (end.x - start.x) / 2, start.y), Pair.of(end.x, start.y + (end.y - start.y) / 2));
        node.bottomLeft = buildTreePart(grid, Pair.of(start.x, start.y + (end.y - start.y) / 2), Pair.of(start.x + (end.x - start.x) / 2, end.y));
        node.bottomRight = buildTreePart(grid, Pair.of(start.x + (end.x - start.x) / 2, start.y + (end.y - start.y) / 2), Pair.of(end.x, end.y));
        return node;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Pair of(int x, int y) {
            return new Pair(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };

        construct(grid);
    }
}
