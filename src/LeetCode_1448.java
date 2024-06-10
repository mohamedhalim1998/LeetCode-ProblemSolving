import helper.Helpers;
import helper.Helpers.TreeNode;

public class LeetCode_1448 {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        if (node.val >= val) {
            return 1 + goodNodes(node.right, node.val) + goodNodes(node.left, node.val);
        } else {
            return goodNodes(node.right, val) + goodNodes(node.left, val);
        }
    }
}
