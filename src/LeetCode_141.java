import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head.next;
        var i = 0;
        while (i < 10000 && slow != null && fast != null && fast.next != null && slow != fast) {
            i++;
            slow = slow.next;

                fast = fast.next.next;
        }
        return i != 10000;

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

//        @Override
//        public String toString() {
//            ListNode node = this;
//            StringBuilder builder = new StringBuilder();
//            builder.append("[");
//            while (node != null) {
//                builder.append(node.val).append(" ,");
//                node = node.next;
//            }
//            builder.append("]");
//            return builder.toString();
//
//        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = head;
        System.out.println(hasCycle(head));
    }

}
