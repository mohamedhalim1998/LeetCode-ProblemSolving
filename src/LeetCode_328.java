import java.util.List;
import java.util.Objects;

public class LeetCode_328 {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = head;
        int size = 1;
        while (last.next != null) {
            size++;
            last = last.next;
        }
        if(size == 2) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;

        for (int i = 0; i < size / 2; i++) {
            odd.next = even.next;
            even.next = null;
            last.next = even;
            last = last.next;
            odd = odd.next;
            if(odd == null)
                break;
            even = odd.next;
            if(even == null)
                break;
        }
        return head;

    }

}
