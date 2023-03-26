public class LeetCode_110 {
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
    }

    public boolean isBalanced(TreeNode root) {
        return Math.abs(depth(root.right) - depth(root.left)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(depth(node.right), depth(node.left));
    }
}
