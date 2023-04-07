import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
//        rightSideView(root, list);
        Stack<Item> stack = new Stack<>();
        int maxLevel = -1;
        stack.push(new Item(0, root));
        while (!stack.isEmpty()) {
            Item curr = stack.pop();
            if (curr.level > maxLevel) {
                list.add(curr.node.val);
                maxLevel = curr.level;
            }
            if (curr.node.left != null) {
                stack.push(new Item(curr.level + 1, curr.node.left));
            }
            if (curr.node.right != null) {
                stack.push(new Item(curr.level + 1, curr.node.right));
            }

        }
        return list;
    }

    static class Item {
        int level;
        TreeNode node;

        public Item(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

//    private void rightSideView(TreeNode root, List<Integer> list) {
//        if(root == null)
//            return;
//
//        list.add(root.val);
//
//        if(root.right != null) {
//            rightSideView(root.right, list);
//        } else {
//            rightSideView(root.left, list);
//        }
//
//    }
}
