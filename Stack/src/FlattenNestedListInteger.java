import java.util.*;

/**
 * LeetCode341
 * @author yanliu
 * @create 2022-05-17-11:33 AM
 */
public class FlattenNestedListInteger {
    class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val) {
            this.val = val;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return val;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        Deque<List<NestedInteger>> listStack;
        Deque<Integer> indexStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            indexStack = new ArrayDeque<>();
            listStack = new ArrayDeque<>();

            listStack.push(nestedList);
            indexStack.push(0);

        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int currIntegerIdx = indexStack.pop();
            indexStack.push(currIntegerIdx + 1);

            return listStack.peek().get(currIntegerIdx).getInteger();
        }

        @Override
        public boolean hasNext() {
            makeStackTopInteger();

            return !indexStack.isEmpty();
        }

        private void makeStackTopInteger() {
            while (!indexStack.isEmpty()) {
                if (indexStack.peek() >= listStack.peek().size()) {
                    // the top list was already visited
                    indexStack.pop();
                    listStack.pop();
                    continue;
                }

                if (listStack.peek().get(indexStack.peek()).isInteger()) {
                    break;
                }


                listStack.push(listStack.peek().get(indexStack.peek()).getList());
                indexStack.push(indexStack.pop() + 1);
                indexStack.push(0);
            }
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
