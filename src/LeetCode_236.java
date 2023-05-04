public class LeetCode_236 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        TreeNode ans = null;

        ans = lowestCommonAncestor(root.left, p, q);
        if (ans != null)
            return ans;
        ans = lowestCommonAncestor(root.right, p, q);
        if (ans != null)
            return ans;
        if (find(root, p) && find(root, q))
            ans = root;
        return ans;
    }

    public boolean find(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        return node.val == root.val || find(root.left, node) || find(root.right, node);
    }
}
