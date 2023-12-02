import java.util.ArrayList;

public class LeetCode_117 {
    public class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public Node connect(Node root) {
        ArrayList<ArrayList<Node>> nodesPerLevel = new ArrayList<>();
        populateLevel(root, nodesPerLevel, 0);
        for(var level : nodesPerLevel) {
            for(int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
        }
        return root;
    }

    private void populateLevel(Node node, ArrayList<ArrayList<Node>> nodesPerLevel, int level) {
        if(node == null)
            return;
        if(nodesPerLevel.size() == level)
            nodesPerLevel.add(new ArrayList<>());
        nodesPerLevel.get(level).add(node);
        populateLevel(node.left, nodesPerLevel, level + 1);
        populateLevel(node.right, nodesPerLevel, level + 1);
    }
}
