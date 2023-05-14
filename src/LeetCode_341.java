import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode_341 {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private NestedInteger nestedInteger;

        public NestedIterator(List<NestedInteger> nestedList) {
            ArrayList<Integer> list = new ArrayList<>();
            flatList(list, nestedList);
            iterator = list.iterator();
        }

        private void flatList(ArrayList<Integer> list, List<NestedInteger> nestedList) {
            for (NestedInteger x : nestedList) {
                if (x.isInteger()) {
                    list.add(x.getInteger());
                } else {
                    flatList(list, x.getList());
                }
            }
        }

        @Override
        public Integer next() {
           return iterator.next();
        }

        @Override
        public boolean hasNext() {
           return iterator.hasNext();
        }
    }


}
