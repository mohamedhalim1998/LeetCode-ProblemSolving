
public class LeetCode_106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInorder = i;
                break;
            }
        }

        int rightSize = inEnd - rootIndexInorder;
        root.right = buildTreeHelper(postorder, postStart, postEnd - 1,
                inorder, rootIndexInorder + 1, inEnd);
        root.left = buildTreeHelper(postorder, postStart, postEnd - rightSize - 1,
                inorder, inStart, rootIndexInorder - 1);



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


}
