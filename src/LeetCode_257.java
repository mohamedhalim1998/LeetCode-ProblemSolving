import helper.Helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        var list = new ArrayList<String>();
        binaryTreePaths(root, list, new StringBuilder());
        return list;
    }

    private void binaryTreePaths(TreeNode node, ArrayList<String> list, StringBuilder path) {
        if(node == null){
            return;
        }
        if (isLeaf(node)) {
            list.add(!path.isEmpty() ? path + "->" + node.val : "" + node.val);
        } else {
            binaryTreePaths(node.left, list, !path.isEmpty() ? path.append("->").append(node.val) : path.append(node.val));
            binaryTreePaths(node.right, list, !path.isEmpty() ? path.append("->").append(node.val) : path.append(node.val));
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
