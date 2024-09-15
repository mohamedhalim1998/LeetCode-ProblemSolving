import helper.Helpers;
import helper.Helpers.ListNode;
import org.junit.jupiter.api.Test;

public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        var newHead = head.next;
        ListNode prev = null;
        var curr = head;
        var next = head.next;
        while (next != null) {
            swap(prev, curr, next);
            prev = curr;
            curr = curr.next;
            if(curr == null){
                break;
            }
            next = curr.next;
        }
        return newHead;
    }

    private void swap(ListNode prev, ListNode curr, ListNode next) {
        curr.next = next.next;
        next.next = curr;
        if (prev != null)
            prev.next = next;
    }
    @Test
    public void test() {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4});
        swapPairs(head);
    }

}
