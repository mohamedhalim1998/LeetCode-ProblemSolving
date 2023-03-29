import java.util.ArrayList;

public class LeetCode_230 {
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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return dfs(root);
    }

    int dfs(TreeNode node) {
        if (node == null) return -1;
        int ans = dfs(node.left);
        if (ans != -1) return ans;
        if (count == 1) return node.val;
        count--;
        return dfs(node.right);
    }
    private ArrayList<Integer> convertToList(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        convertToList(root.left, list);
        list.add(root.val);
        convertToList(root.right, list);
        return list;
    }

    private void convertToList(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;
        convertToList(node.left, list);
        list.add(node.val);
        convertToList(node.right, list);
    }

    private int countLess(TreeNode node, int init) {
        if (node == null)
            return 0;
        return init + count(node.left);
    }

    private int count(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + count(node.left) + count(node.right);
    }


}
