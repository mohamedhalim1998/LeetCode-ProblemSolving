package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Helpers {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode fromArray(int[] arr) {
            ListNode node = new ListNode(arr[0]);
            ListNode last = node;
            for (int i = 1; i < arr.length; i++) {
                ListNode newNode = new ListNode(arr[i]);
                last.next = newNode;
                last = newNode;

            }
            return node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode list2 = (ListNode) o;
            ListNode list1 = this;
            boolean res = true;
            while (list1 != null && list2 != null) {
                res &= list1.val == list2.val;
                list1 = list1.next;
                list2 = list2.next;
            }
            res &= !((list1 == null && list2 != null) || (list1 != null && list2 == null));
            return res;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            while (node != null) {
                builder.append(node.val).append(" ,");
                node = node.next;
            }
            builder.append("]");
            return builder.toString();

        }
    }
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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
        public static TreeNode fromArray(Integer[] array) {
            if (array.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(array[0]);
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(root);
            int index = 1;
            boolean left = true;

            while (index < array.length) {
                TreeNode current = nodes.get(0);

                if (left) {
                    if (array[index] != null) {
                        TreeNode newNode = new TreeNode(array[index]);
                        current.left = newNode;
                        nodes.add(newNode);
                    }
                    left = false;
                } else {
                    if (array[index] != null) {
                        TreeNode newNode = new TreeNode(array[index]);
                        current.right = newNode;
                        nodes.add(newNode);
                    }
                    nodes.remove(0);
                    left = true;
                }
                index++;
            }

            return root;
        }


    }
    static int greaterSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int lessSearch(Integer[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    static HashMap<Integer, ArrayList<Integer>> arrToFreqMap(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        return map;
    }
    static void bitmask(int n) {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                }
            }
        }
    }

}
