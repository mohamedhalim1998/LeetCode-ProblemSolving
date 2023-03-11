import java.util.ArrayList;
import java.util.List;

public class LeetCode_102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 0, ans);
        return ans;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if(root.left == null)
            return;
        if(level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        levelOrder(root.left, level + 1, ans);
        levelOrder(root.right, level + 1, ans);
    }
}
