import java.util.ArrayList;
import java.util.Iterator;

public class LeetCode_173 {
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


    class BSTIterator {
        Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            iterator = convertToList(root).iterator();
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
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
    }
}
