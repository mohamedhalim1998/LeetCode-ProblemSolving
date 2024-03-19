import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode_133 {
    static public class Node {
        public int val;
        public List<Node> neighbors;
    }

    public Node cloneGraph(Node node) {
      return cloneGraph(node, null, new HashMap<>());
    }

    private Node cloneGraph(Node node, Node parent, HashMap<Integer, Node> visited) {
        if (node == null)
            return null;
        if(visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node copy = new Node();
        copy.val = node.val;
        visited.put(copy.val, copy);
        if (node.neighbors == null || node.neighbors.isEmpty()) {
            return copy;
        }
        var copyNeighbors = new ArrayList<Node>();
        for (var curr : node.neighbors) {
            if(parent != null && parent.val == curr.val) {
                copyNeighbors.add(parent);
            } else {
                copyNeighbors.add(cloneGraph(curr, copy, visited));
            }
        }
        copy.neighbors = copyNeighbors;
        return copy;
    }

    @Test
    public void test_1() {
        Node node = new Node();
        node.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 3;
        node.neighbors = List.of(node2, node3);
        node2.neighbors = List.of(node, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node, node3);
        cloneGraph(node);


    }
}
