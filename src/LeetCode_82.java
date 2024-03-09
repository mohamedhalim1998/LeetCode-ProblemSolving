import java.util.Objects;

public class LeetCode_82 {
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

    // [1,2,3,3,4,4,5]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode res = null;
        ListNode resLast = null;
        var curr = head;
        var next = head.next;
        if(next == null)
            return head;
        while (next != null) {
            if (curr.val != next.val) {
                if (res == null) {
                    res = new ListNode();
                    res.val = curr.val;
                    resLast = res;
                } else {
                    var node = new ListNode();
                    node.val = curr.val;
                    resLast.next = node;
                    resLast = node;
                }
                curr = next;
                next = curr.next;
            } else {
                int duplicatedValue = curr.val;
                while (next != null && next.val == duplicatedValue) {
                    next = next.next;
                }
                if(next != null) {
                    curr = next;
                    next = curr.next;
                } else {
                    curr = null;
                }
            }
            if(curr != null && next == null) {
                if (res == null) {
                    res = new ListNode();
                    res.val = curr.val;
                    resLast = res;
                } else {
                    var node = new ListNode();
                    node.val = curr.val;
                    resLast.next = node;
                    resLast = node;
                }
            }
        }
        return res;
    }

}
