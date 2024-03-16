public class LeetCode_530 {
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

    public int getMinimumDifference(TreeNode root) {

        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }
        if (root.left != null) {
            min = Math.min(min, Math.abs(root.val - root.left.val));
            min = Math.min(min, Math.abs(root.val - getMostRight(root.left)));
            min = Math.min(min, getMinimumDifference(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, Math.abs(root.val - root.right.val));
            min = Math.min(min, Math.abs(root.val - getMostLeft(root.right)));
            min = Math.min(min, getMinimumDifference(root.right));
        }
        return min;
    }

    private int getMostRight(TreeNode root) {
        if(root.right == null){
            return root.val;
        }
        return getMostRight(root.right);
    }
    private int getMostLeft(TreeNode root) {
        if(root.left == null){
            return root.val;
        }
        return getMostLeft(root.left);
    }
}
