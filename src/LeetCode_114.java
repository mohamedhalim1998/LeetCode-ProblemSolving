import java.util.LinkedList;

public class LeetCode_114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public void flatten(TreeNode root) {
        var linkedList = new LinkedList<TreeNode>();
        popualateList(root, linkedList);
        linkedList.removeFirst();
        var curr = root;
        while (!linkedList.isEmpty()) {
            curr.left = null;
            curr.right = linkedList.removeFirst();
            curr = curr.right;
        }
    }

    private void popualateList(TreeNode node, LinkedList<TreeNode> linkedList) {
        if(node == null)
            return;
        linkedList.add(node);
        popualateList(node.left, linkedList);
        popualateList(node.right, linkedList);

    }
}
