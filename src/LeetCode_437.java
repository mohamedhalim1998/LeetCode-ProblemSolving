import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LeetCode_437 {
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

    int count = 0;
    HashSet<Item> set = new HashSet<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return pathSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    private int pathSum(TreeNode root, long targetSum, long i) {
        if (root == null)
            return 0;
        int count = 0;
        if (i + root.val== targetSum)
            count++;

        count += pathSum(root.left, targetSum, i + root.val);
        count += pathSum(root.right, targetSum, i + root.val);
        return count;
    }

    static class Item {
        TreeNode node;
        int sum;

        public Item(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return sum == item.sum && Objects.equals(node, item.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, sum);
        }
    }

    @Test
    public void test_1() {
        Integer[] arr = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        Assertions.assertEquals(3, pathSum(TreeNode.arrayToTree(arr), 8));
    }

    @Test
    public void test_2() {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Assertions.assertEquals(3, pathSum(TreeNode.arrayToTree(arr), 22));
    }

    @Test
    public void test_3() {
        Integer[] arr = {-2, null, -3};
        Assertions.assertEquals(1, pathSum(TreeNode.arrayToTree(arr), -3));
    }

    @Test
    public void test_4() {
        Integer[] arr = {0, 1, 1};
        Assertions.assertEquals(4, pathSum(TreeNode.arrayToTree(arr), 1));
    }    @Test
    public void test_5() {
        Integer[] arr = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        Assertions.assertEquals(0, pathSum(TreeNode.arrayToTree(arr), 1));
    }


}
