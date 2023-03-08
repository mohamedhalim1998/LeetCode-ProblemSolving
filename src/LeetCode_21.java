import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_21 {
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
            if(arr.length == 0)
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode merge = null;
        ListNode node3 = null;
        while (node1 != null || node2 != null) {
            ListNode newNode;
            if (node1 == null) {
                newNode = new ListNode(node2.val);
                node2 = node2.next;
            } else if (node2 == null) {
                newNode = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                if (node1.val < node2.val) {
                    newNode = new ListNode(node1.val);
                    node1 = node1.next;
                } else {
                    newNode = new ListNode(node2.val);
                    node2 = node2.next;
                }
            }
            if (merge == null) {
                merge = newNode;
                node3 = newNode;
            } else {
                node3.next = newNode;
                node3 = node3.next;
            }
        }
        return merge;
    }

    @Test
    public void test_1() {
        int[] list1 = {1, 2, 4}, list2 = {1, 3, 4};
        int[] merge = {1, 1, 2, 3, 4, 4};
        Assertions.assertEquals(ListNode.fromArray(merge), mergeTwoLists(ListNode.fromArray(list1), ListNode.fromArray(list2)));
    }


    @Test
    public void test_2() {
        int[] list1 = {}, list2 = {};
        int[] merge = {};
        Assertions.assertEquals(ListNode.fromArray(merge), mergeTwoLists(ListNode.fromArray(list1), ListNode.fromArray(list2)));
    }

    @Test
    public void test_3() {
        int[] list1 = {}, list2 = {4};
        int[] merge = {4};
        Assertions.assertEquals(ListNode.fromArray(merge), mergeTwoLists(ListNode.fromArray(list1), ListNode.fromArray(list2)));
    }


}
