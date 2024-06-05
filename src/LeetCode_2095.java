import helper.Helpers;
import helper.Helpers.ListNode;

public class LeetCode_2095 {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode prev = null;
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
