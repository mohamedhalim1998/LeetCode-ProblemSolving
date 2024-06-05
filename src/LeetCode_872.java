import helper.Helpers;
import helper.Helpers.TreeNode;

import java.util.ArrayList;
import java.util.Objects;

public class LeetCode_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var tree1 = new ArrayList<Integer>();
        var tree2 = new ArrayList<Integer>();
        extractLeaves(root1, tree1);
        extractLeaves(root2, tree2);
        return Objects.equals(tree2, tree1);
    }

    private void extractLeaves(TreeNode node, ArrayList<Integer> list) {
        if(node == null)
            return;
        if(node.left == null && node.right == null) {
            list.add(node.val);
        }
        extractLeaves(node.left, list);
        extractLeaves(node.right, list);
    }
}
