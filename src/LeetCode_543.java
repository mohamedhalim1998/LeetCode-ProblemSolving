import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_543 {
    public static class TreeNode {
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

        public static TreeNode arrayToTree(Integer[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(arr[0]);
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                TreeNode node = queue.poll();

                if (arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                i++;

                if (i < arr.length && arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i++;
            }

            return root;
        }

        public static TreeNode arrayToTree(Integer[] arr, int start, int end) {
            // Base case
            if (start > end) {
                return null;
            }

            // Get the middle element and make it the root node
            int mid = (start + end) / 2;
            TreeNode root = null;
            if (arr[mid] != null) {
                root = new TreeNode(arr[mid]);

                // Recursively construct the left and right subtrees
                root.left = arrayToTree(arr, start, mid - 1);
                root.right = arrayToTree(arr, mid + 1, end);
            }

            return root;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[" + val + ", ");
            if (left != null) {
                sb.append(left.toString());
            } else {
                sb.append("null");
            }
            sb.append(", ");
            if (right != null) {
                sb.append(right.toString());
            } else {
                sb.append("null");
            }
            sb.append("]");
            return sb.toString();
        }

        public static String toString(TreeNode root) {
            if (root == null) {
                return "null";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int levelSize = 1;
            while (!queue.isEmpty()) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        sb.append(node.val).append(" ");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        sb.append("null ");
//                        queue.offer(null);
//                        queue.offer(null);
                    }
                }
                sb.append("\n");
                levelSize = queue.size();
            }

            return sb.toString();
        }

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int max = len(root.right) + len(root.left);
        max = Math.max(max, diameterOfBinaryTree(root.left));
        max = Math.max(max, diameterOfBinaryTree(root.right));
        return max;
    }

    private int len(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(len(node.left), len(node.right));
    }

    @Test
    public void test_1() {
        Integer[] arr = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
        System.out.println(TreeNode.toString(TreeNode.arrayToTree(arr)));
        System.out.println(TreeNode.arrayToTree(arr));
        Assertions.assertEquals(8, diameterOfBinaryTree(TreeNode.arrayToTree(arr)));
    }
}
