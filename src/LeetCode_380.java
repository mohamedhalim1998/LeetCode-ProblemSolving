import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class LeetCode_380 {
    class RandomizedSet {
        final int SIZE = 100;
        ArrayList<LinkedList<Integer>> set = new ArrayList<>(SIZE);
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {
            for (int i = 0; i < SIZE; i++) {
                set.add(new LinkedList<>());
            }
        }

        public boolean insert(int val) {
            if (contains(val))
                return false;
            int index = getIndex(val);
            set.get(index).add(val);
            if (!list.contains(index))
                list.add(index);
            return true;
        }

        private boolean contains(int val) {
            int index = getIndex(val);
            return set.get(index).contains(val);
        }

        private int getIndex(int val) {
            return Math.abs(val) % SIZE;
        }

        public boolean remove(int val) {
            if (!contains(val))
                return false;
            int index = getIndex(val);
            set.get(index).remove((Integer) val);
            if (set.get(index).size() == 0)
                list.remove((Integer) index);
            return true;
        }

        public int getRandom() {
            int x = random.nextInt(list.size());
            System.out.println(x);
            int y = random.nextInt(set.get(list.get(x)).size());
            return set.get(x).get(y);
        }
    }
}
