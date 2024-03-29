public class LeetCode_116 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }




    public Node connect(Node root) {
        connectHelper(root, null);
        return root;
    }

    private void connectHelper(Node root, Node parent) {
        if(root == null)
            return;
        if(root.left!= null) {
            root.left.next = root.left;
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        connectHelper(root.left, root);
        connectHelper(root.right, root);

    }


}
