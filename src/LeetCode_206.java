import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_206 {
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
            if (arr.length == 0)
                return null;
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
            //            ListNode node = this;
            //            StringBuilder builder = new StringBuilder();
            //            builder.append("[");
            //            while (node != null) {
            //                builder.append(node.val).append(" ,");
            //                node = node.next;
            //            }
            //            builder.append("]");
            //            return builder.toString();
            return this.val + "";
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = head;
            prev.next = next;
            head = curr;
            curr = next;
            next = next.next;
        }
        curr.next = head;
        head = curr;
        prev.next = next;

        return head;
    }

    @Test
    public void test_1() {
        int[] list = {1, 2, 3, 4, 5};
        int[] rev = {5, 4, 3, 2, 1};
        Assertions.assertEquals(ListNode.fromArray(rev), reverseList(ListNode.fromArray(list)));
    }  @Test
    public void test_2() {
        int[] list = {1, 2};
        int[] rev = {2,1};
        Assertions.assertEquals(ListNode.fromArray(rev), reverseList(ListNode.fromArray(list)));
    }
    @Test
    public void test_3() {
        int[] list = {1};
        int[] rev = {1};
        Assertions.assertEquals(ListNode.fromArray(rev), reverseList(ListNode.fromArray(list)));
    }
    @Test
    public void test_4() {
        int[] list = {};
        int[] rev = {};
        Assertions.assertEquals(ListNode.fromArray(rev), reverseList(ListNode.fromArray(list)));
    }

}
