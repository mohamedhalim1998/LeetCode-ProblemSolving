import helper.Helpers;
import helper.Helpers.TreeNode;
import org.junit.jupiter.api.Test;

public class LeetCode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root == null)
           return null;
       TreeNode parentNode = null;
       TreeNode curr = root;
       while (curr != null && curr.val != key) {
           parentNode = curr;
           if(curr.val > key) {
               curr = curr.left;
           } else {
               curr = curr.right;
           }
       }
       if(curr == null){
           return root;
       }
       if(parentNode == null) {
           return deleteRoot(root);
       }
       if(curr.left == null && curr.right == null) {
           if(parentNode.val > curr.val) {
               parentNode.left = null;
           } else {
               parentNode.right = null;
           }
       } else if(curr.right != null) {
           if(parentNode.val > curr.val) {
               parentNode.left = deleteRoot(curr);
           } else {
               parentNode.right = deleteRoot(curr);
           }
       } else {
           if(parentNode.val > curr.val) {
               parentNode.left =  deleteRoot(curr);
           } else {
               parentNode.right =  deleteRoot(curr);
           }
       }
       return root;

    }

    private TreeNode deleteRoot(TreeNode root) {
        if(root.left == null && root.right == null) {
            return null;
        } else if(root.right != null) {
            var leftMost = root.right;
            TreeNode parent = null;
            while (leftMost.left != null) {
                parent = leftMost;
                leftMost = leftMost.left;
            }
            if(parent != null) {
                parent.left = leftMost.right;
                leftMost.right = root.right;
            }
            leftMost.left = root.left;
            return leftMost;
        } else {
            var rightMost = root.left;
            TreeNode parent = null;
            while (rightMost.right != null) {
                parent = rightMost;
                rightMost = rightMost.right;
            }
            if(parent != null) {
                parent.right = rightMost.left;
                rightMost.left = root.left;
            }
            rightMost.right = root.right;
            return rightMost;
        }
    }

    @Test
    public void test() {
        TreeNode tree = TreeNode.fromArray(new Integer[]{5, 3, 6, 2, 4, null, 7});
        deleteNode(tree, 3);
    }
}
