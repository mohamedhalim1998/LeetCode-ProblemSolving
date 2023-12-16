public class LeetCode_112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int currSum, int targetSum) {
        if(node == null)
            return false;
        if (node.left == null && node.right == null)
            return currSum + node.val == targetSum;
        return hasPathSum(node.left, currSum + node.val, targetSum) || hasPathSum(node.right, currSum + node.val, targetSum);
    }


}
