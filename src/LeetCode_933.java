import java.util.LinkedList;

public class LeetCode_933 {
    class RecentCounter {
        private LinkedList<Integer> list;
        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            list.add(t);
            var min = t - 3000;
            while (list.peek() < min) {
                list.remove();
            }
            return list.size();
        }
    }

}
