import helper.Helpers.ListNode;

public class LeetCode_2807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            var gcd = gcd(curr.val, next.val);
            var node = new ListNode();
            node.next = next;
            node.val = gcd;
            curr.next = node;
            curr = next;
            next = next.next;
        }
        return head;
    }

    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
