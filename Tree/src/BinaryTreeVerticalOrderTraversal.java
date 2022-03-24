import java.util.*;

/**
 * @author yanliu
 * @create 2021-12-23-10:59 PM
 */
public class BinaryTreeVerticalOrderTraversal {
    static class Solution1 {
        class Pair {
            TreeNode node;
            int column;

            public Pair(TreeNode node, int column) {
                this.node = node;
                this.column = column;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Map<Integer, List<Integer>> columnToValues = new HashMap<>();
            Queue<Pair> queue = new ArrayDeque<>();
            int column = 0;

            queue.offer(new Pair(root, column));

            while (!queue.isEmpty()) {
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                column = currPair.node.val;

                if (!columnToValues.containsKey(column)) {
                    columnToValues.put(column, new ArrayList<>());
                }

                columnToValues.get(column).add(currNode.val);

                if (currNode.left != null) {
                    queue.offer(new Pair(currNode.left, column - 1));
                }

                if (currNode.right != null) {
                    queue.offer(new Pair(currNode.right, column + 1));
                }
            }

            List<Integer> sortedKeys = new ArrayList<>(columnToValues.keySet());
            Collections.sort(sortedKeys);

            for (Integer key : sortedKeys) {
                res.add(columnToValues.get(key));
            }

            return res;
        }
    }

    static class Solution2 {
        class Pair {
            int row;
            int val;

            public Pair(int row, int val) {
                this.row = row;
                this.val = val;
            }
        }

        private int minCol = Integer.MAX_VALUE;
        private int maxCol = Integer.MIN_VALUE;

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Map<Integer, List<Pair>> columnToPairs = new HashMap<>();

            dfs(root, 0, 0, columnToPairs);

            for (int i = minCol; i <= maxCol; i++) {
                if (!columnToPairs.containsKey(i)) {
                    continue;
                }

                List<Pair> pairs = columnToPairs.get(i);

                // sort the pairs based on the row in ascending order
                Collections.sort(pairs, new Comparator<Pair>(){
                    public int compare(Pair o1, Pair o2) {
                        return o1.row - o2.row;
                    }
                });

                List<Integer> curr = new ArrayList<>();

                for (Pair pair : pairs) {
                    curr.add(pair.val);
                }

                res.add(curr);
            }

            return res;

        }

        private void dfs(TreeNode root, int row, int col,
                         Map<Integer, List<Pair>> columnToPairs) {
            if (root == null) {
                return;
            }

            if (!columnToPairs.containsKey(col)) {
                columnToPairs.put(col, new ArrayList<>());
            }

            columnToPairs.get(col).add(new Pair(row, root.val));

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            dfs(root.left, row + 1, col - 1, columnToPairs);
            dfs(root.right, row + 1, col + 1, columnToPairs);
        }
    }


}
