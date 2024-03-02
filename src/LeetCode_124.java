import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode_124 {
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

    public int maxPathSum(TreeNode root) {
        AtomicInteger maxSoFar = new AtomicInteger(Integer.MIN_VALUE);

        maxPathSum(root, maxSoFar);
        return maxSoFar.get();
    }

    public int maxPathSum(TreeNode root, AtomicInteger max) {
        if(root == null)
            return 0;
        int maxLeft = maxPathSum(root.left, max);
        int maxRight = maxPathSum(root.right, max);
        return max(maxLeft, maxRight, root.val, max);
    }

    private int max(int maxLeft, int maxRight, int val, AtomicInteger maxSoFar) {
        int[] arr = {val, maxLeft + val, maxRight + val};
        Arrays.sort(arr);
        maxSoFar.set(Math.max(maxLeft + maxRight + val, Math.max(maxSoFar.get(), arr[arr.length - 1])));
        return  arr[arr.length - 1];
    }

    public int maxPathSum2(TreeNode root) {
        int max_sum = Integer.MIN_VALUE;
        Stack<SimpleEntry<TreeNode, Integer>> stack
                = new Stack<>();
        stack.push(new SimpleEntry<>(root, 0));

        while (!stack.empty()) {
            SimpleEntry<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int state = pair.getValue();

            if (node == null) {
                continue;
            }

            if (state == 0) {
                // first visit to the node
                stack.push(new SimpleEntry<>(node, 1));
                stack.push(new SimpleEntry<>(node.left, 0));
            }
            else if (state == 1) {
                // second visit to the node
                stack.push(new SimpleEntry<>(node, 2));
                stack.push(
                        new SimpleEntry<>(node.right, 0));
            }
            else {
                // third visit to the node
                int left_sum = (node.left != null)
                        ? node.left.val
                        : 0;
                int right_sum = (node.right != null)
                        ? node.right.val
                        : 0;
                max_sum = Math.max(
                        max_sum, node.val
                                + Math.max(0, left_sum)
                                + Math.max(0, right_sum));
                int max_child_sum
                        = Math.max(left_sum, right_sum);
                node.val += Math.max(0, max_child_sum);
            }
        }

        return max_sum;
    }

}
