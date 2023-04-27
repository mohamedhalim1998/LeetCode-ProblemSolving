import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> original = new HashMap<>();
        Node curr = head;
        int index = 0;
        while (curr != null) {
            original.put(curr, index);
            index++;
            curr = curr.next;
        }
        Node copyHead = null;
        HashMap<Integer, Node> copy = new HashMap<>();
        curr = head;
        index = 0;
        Node last = null;
        while (curr != null) {
            Node node = new Node(curr.val);
            if (copyHead == null) {
                copyHead = node;
            } else {
                last.next = node;
            }
            last = node;
            copy.put(index, node);
            curr = curr.next;
            index++;
        }
        curr = head;
        Node currCopy = copyHead;
        while (curr != null) {
            if (curr.random != null) {
                currCopy.random = copy.get(original.get(curr.random));
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return copyHead;
    }

    @Test
    public void  test() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.random = head.next;
        copyRandomList(head);
    }

}
