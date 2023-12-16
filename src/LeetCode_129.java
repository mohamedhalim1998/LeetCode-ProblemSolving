import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_129 {
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

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int currSum) {
        if(node == null)
            return currSum;
        if(node.left == null && node.right == null)
            return currSum * 10 + node.val;
        if(node.left == null)
            return  sumNumbers(node.right, currSum * 10 + node.val);
        if(node.right == null)
            return  sumNumbers(node.left, currSum * 10 + node.val);
        return sumNumbers(node.left, currSum * 10 + node.val) + sumNumbers(node.right, currSum * 10 + node.val);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
       // root.right = new TreeNode(3);
        Assertions.assertEquals(10, sumNumbers(root));
    }
}
