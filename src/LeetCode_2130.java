import helper.Helpers;
import helper.Helpers.ListNode;
import org.junit.jupiter.api.Test;

public class LeetCode_2130 {
    public int pairSum(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        var reverse = reverseList(slow);
//        System.out.println(reverse);
        var n1 = head;
        var n2 = reverse;
        int max = Integer.MIN_VALUE;
        while (n1 != null) {
            max = Math.max(n1.val + n2.val, max);
            n1 = n1.next;
            n2 = n2.next;
        }
        return max;
    }

    public int pairSum2(ListNode head) {
        var reverse = reverseList(head);
        System.out.println(reverse);
        var n1 = head;
        var n2 = reverse;
        int max = Integer.MIN_VALUE;
        while (n2 != null) {
            max = Math.max(n1.val + n2.val, max);
            n1 = n1.next;
            n2 = n2.next;
        }
        return max;
    }

    private ListNode reverseList(ListNode head) {
        ListNode copy = copyList(head);
        ListNode prev = null;
        ListNode curr = copy;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    private ListNode copyList(ListNode head) {
        ListNode head2 = new ListNode(head.val);
        ListNode curr = head.next;
        ListNode last = head2;
        while (curr != null) {
            ListNode node = new ListNode(curr.val);
            last.next = node;
            last = node;
            curr = curr.next;
        }
        return head2;

    }

    @Test
    public void test1() {
        ListNode listNode = ListNode.fromArray(new int[]{47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9});
        System.out.println(listNode);
        pairSum(listNode);
    }
}
