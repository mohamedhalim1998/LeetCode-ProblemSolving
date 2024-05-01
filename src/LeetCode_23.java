import java.util.Objects;
import java.util.PriorityQueue;

public class LeetCode_23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        var heap = new PriorityQueue<HeapNode>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(new HeapNode(lists[i], i));
            }
        }
        ListNode ans = null;
        ListNode curr = null;
        while (!heap.isEmpty()) {
            var heapNode = heap.poll();
            if(ans == null) {
                ans = new ListNode(heapNode.node.val);
                curr = ans;
            } else {
                curr.next = new ListNode(heapNode.node.val);
                curr = curr.next;
            }
            if(heapNode.node.next != null) {
                heap.add(new HeapNode(heapNode.node.next, heapNode.index));
            }
        }
        return ans;

    }

    public static class HeapNode implements Comparable<HeapNode> {
        ListNode node;
        int index;

        public HeapNode(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

        @Override
        public int compareTo(HeapNode heapNode) {
            return Integer.compare(node.val, heapNode.node.val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HeapNode heapNode = (HeapNode) o;
            return Objects.equals(node.val, heapNode.node.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node.val);
        }
    }
}
