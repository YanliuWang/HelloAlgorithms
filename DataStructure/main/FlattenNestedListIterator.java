import java.util.*;

/**
 * LeetCode341
 * @author yanliu
 * @create 2022-03-24-3:46 PM
 */
public class FlattenNestedListIterator {
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

    static class Solution1 {
        class NestedIterator implements Iterator<Integer> {
            private List<Integer> flattenList;
            private int ptr;

            public NestedIterator(List<NestedInteger> nestedList) {
                flattenList = new ArrayList<>();
                ptr = 0;

                flatten(nestedList);

            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return flattenList.get(ptr++);
            }

            @Override
            public boolean hasNext() {
                return ptr < flattenList.size();
            }

            private void flatten(List<NestedInteger> nestedList) {
                for (NestedInteger nested : nestedList) {
                    if (nested.isInteger()) {
                        flattenList.add(nested.getInteger());

                    } else {
                        flatten(nested.getList());

                    }
                }
            }
        }
    }

    static class Solution2 {
        class NestedIterator implements Iterator<Integer> {
            Deque<NestedInteger> stack;

            public NestedIterator(List<NestedInteger> nestedList) {
                stack = new ArrayDeque<>(nestedList);
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return stack.pop().getInteger();
            }

            @Override
            public boolean hasNext() {
                makeTopInteger();

                return !stack.isEmpty();
            }

            private void makeTopInteger() {
                while (!stack.isEmpty() && !stack.peek().isInteger()) {
                    List<NestedInteger> first = stack.pop().getList();

                    for (int i = first.size() - 1; i >= 0; i--) {
                        stack.push(first.get(i));
                    }

                }
            }
        }
    }

}
