import helper.Helpers.TreeNode;

import java.util.HashMap;

public class LeetCode_1161 {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        maxLevelSum(root, map, 0);
        int max = 0;
        for(var e : map.entrySet()) {
            if(map.get(max) < e.getValue()) {
                max = e.getKey();
            }
        }
        return max + 1;

    }

    private void maxLevelSum(TreeNode node, HashMap<Integer, Integer> map, int level) {
        if (node == null)
            return;
        map.put(level, map.getOrDefault(level, 0) + node.val);
        maxLevelSum(node.left, map, level + 1);
        maxLevelSum(node.right, map, level + 1);
    }
}
