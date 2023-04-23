import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_105 {
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

    static int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInorder = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndexInorder - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, rootIndexInorder - 1);

        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, rootIndexInorder + 1, inEnd);

        return root;
    }
    private boolean between(int[] inorder, int i, int val, int val1) {

        return indexOf(inorder, i) > indexOf(inorder, val) && indexOf(inorder, i) < indexOf(inorder, val1);
    }

    private boolean isLeft(int[] inorder, int i, int val) {
        return indexOf(inorder, i) < indexOf(inorder, val);
    }

    private int indexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        buildTree(preorder, inorder);
    }

    @Test
    public void test2() {
        int[] inorder = {-1};
        int[] preorder = {-1};
        buildTree(preorder, inorder);
    }
}
