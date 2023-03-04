import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class LeetCode_725 {

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

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int div = size / k;
        int rem = size % k;
        node = head;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int limit = div + (rem <= 0 ? 0 : 1);
            res[i] = null;
            ListNode sub = res[i];
            rem--;
            for (int j = 0; j < limit; j++) {
                if (node == null) {
                    break;
                }
                if (sub == null) {
                    sub = new ListNode(node.val);
                    res[i] = sub;
                } else {
                    ListNode newNode = new ListNode(node.val);
                    sub.next = newNode;
                    sub = newNode;
                }
                node = node.next;
            }
        }
        return res;
    }

    @Test
    public void test_1() {
        System.out.println(Arrays.toString(splitListToParts(ListNode.fromArray(new int[]{1, 2, 3}), 5)));
    }

}
