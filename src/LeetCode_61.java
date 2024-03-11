import org.junit.Test;

import java.util.Objects;

public class LeetCode_61 {
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode last = null;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            if(curr.next == null) {
                last = curr;
            }
            curr = curr.next;
        }
        k = size - (k % size) - 1;
        curr = head;
        while (k-- > 0) {
            curr = curr.next;
        }
        var newHead = curr.next;
        curr.next = null;
        last.next = head;
        return newHead;
    }

    @Test
    public void test1() {
        ListNode list = ListNode.fromArray(new int[]{1,2,3,4,5});
        System.out.println(rotateRight(list, 2));
    }
}
