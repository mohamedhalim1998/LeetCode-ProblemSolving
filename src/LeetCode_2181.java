import helper.Helpers;
import helper.Helpers.ListNode;

public class LeetCode_2181 {
    public ListNode mergeNodes(ListNode head) {
        var ans = new ListNode();
        ListNode ansNext = ans;
        if (head == null) {
            return ans;
        }
        var curr = head.next;
        int sum = 0;
        while (curr != null) {
            if (curr.val == 0) {
                ansNext.val = sum;
                if (curr.next != null) {
                    ansNext.next = new ListNode();
                    ansNext = ansNext.next;
                }
                sum = 0;
            } else {
                sum += curr.val;
            }
            curr = curr.next;
        }
        return ans;
    }
}
