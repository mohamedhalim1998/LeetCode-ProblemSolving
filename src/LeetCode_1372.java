import helper.Helpers.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_1372 {
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        return longestZigZag(root, true, 0) - 1;
    }

    private int longestZigZag(TreeNode node, boolean right, int count) {
        if (node == null)
            return count;
        int max = 0;
        if (right) {
            max = Math.max(max, longestZigZag(node.right, false, count + 1));
            max = Math.max(max, longestZigZag(node.right, true, 0));
        } else {
            max = Math.max(max, longestZigZag(node.left, true, count + 1));
            max = Math.max(max, longestZigZag(node.left, false, 0));

        }

        return max;
    }

    public static class TreeNodeKey {
        public TreeNode treeNode;
        public boolean right;

        public TreeNodeKey(TreeNode treeNode, boolean right) {
            this.treeNode = treeNode;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNodeKey that = (TreeNodeKey) o;
            return right == that.right && Objects.equals(treeNode, that.treeNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(treeNode, right);
        }
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.fromArray(new Integer[]{1, 1, 1, 1, 1, 1, 1, null, null, null, null, null, null, 1, 1, null, null, 1});
        System.out.println(longestZigZag(root));
    }
}
