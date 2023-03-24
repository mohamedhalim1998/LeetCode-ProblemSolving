import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class LeetCode_148 {
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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        return fromArray(list);

    }
    public static ListNode fromArray(ArrayList<Integer> arr) {
        if(arr.size() == 0)
            return null;
        ListNode node = new ListNode(arr.get(0));
        ListNode last = node;
        for (int i = 1; i < arr.size(); i++) {
            ListNode newNode = new ListNode(arr.get(i));
            last.next = newNode;
            last = newNode;

        }
        return node;
    }
}
