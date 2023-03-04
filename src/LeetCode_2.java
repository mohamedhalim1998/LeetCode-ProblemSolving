import java.util.Stack;

public class LeetCode_2 {
    public static void main(String[] args) {

        /**
         * [9,9,9,9,9,9,9]
         * [9,9,9,9]
         */
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        Solution sol = new Solution();
        System.out.println(sol.addTwoNumbers(l1, l2));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode listNode = this;
            StringBuilder out = new StringBuilder();
            while (listNode != null) {
                out.append(listNode.val).append("->");
                listNode = listNode.next;
            }
            out.append("null\n");
            return out.toString();
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode sum = new ListNode();
            ListNode origin = sum;
            int rem = 0;
            while (l1 != null || l2 != null) {
                sum.next = new ListNode();
                sum = sum.next;
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                int s = x + y + rem;
                if (s > 9) {
                    rem = 1;
                    s = s - 10;
                } else {
                    rem = 0;
                }
                sum.val = s;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }

            if (rem == 1) {
                sum.next = new ListNode();
                sum = sum.next;
                sum.val = 1;
            }
            return origin.next;
        }
    }
}
