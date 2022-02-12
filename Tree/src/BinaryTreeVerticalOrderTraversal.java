import java.util.*;

/**
 * @author yanliu
 * @create 2021-12-23-10:59 PM
 */
public class BinaryTreeVerticalOrderTraversal {
    static class Solution1 {
//        public List<List<Integer>> verticalOrder(TreeNode root) {
//            List<List<Integer>> res = new ArrayList<>();
//
//            if (root == null) {
//                return res;
//            }
//
//            Map<Integer, List<Integer>> columnToTreeNodes = new HashMap<>();
//            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
//            int column = 0;
//
//            queue.offer(new Pair(root, column));
//
//            while (!queue.isEmpty()) {
//                Pair<TreeNode, Integer> curr = queue.poll();
//                TreeNode currNode = curr.getKey();
//                column = curr.getValue();
//
//                if (!columnToTreeNodes.containsKey(column)) {
//                    columnToTreeNodes.put(column, new ArrayList<>());
//                }
//
//                columnToTreeNodes.get(column).add(currNode.val);
//
//                if (currNode.left != null) {
//                    queue.offer(new Pair(currNode.left, column - 1));
//                }
//
//                if (currNode.right != null) {
//                    queue.offer(new Pair(currNode.right, column + 1));
//                }
//            }
//
//            List<Integer> sortedKeys = new ArrayList<>(columnToTreeNodes.keySet());
//            Collections.sort(sortedKeys);
//
//            for (Integer key : sortedKeys) {
//                res.add(columnToTreeNodes.get(key));
//            }
//
//            return res;
//        }
    }

    static class Solution2 {
//        public List<List<Integer>> verticalOrder(TreeNode root) {
//            List<List<Integer>> res = new ArrayList<>();
//
//            if (root == null) {
//                return res;
//            }
//
//            Map<Integer, List<Integer>> columnToTreeNodes = new HashMap<>();
//            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
//            int minColumn = Integer.MAX_VALUE;
//            int maxColumn = Integer.MIN_VALUE;
//
//            queue.offer(new Pair(root, 0));
//
//            while (!queue.isEmpty()) {
//                Pair<TreeNode, Integer> curr = queue.poll();
//                TreeNode currNode = curr.getKey();
//                Integer currColumn = curr.getValue();
//
//                if (!columnToTreeNodes.containsKey(currColumn)) {
//                    columnToTreeNodes.put(currColumn, new ArrayList<>());
//                }
//
//                columnToTreeNodes.get(currColumn).add(currNode.val);
//                minColumn = Math.min(minColumn, currColumn);
//                maxColumn = Math.max(maxColumn, currColumn);
//
//                if (currNode.left != null) {
//                    queue.offer(new Pair(currNode.left, currColumn - 1));
//                }
//
//                if (currNode.right != null) {
//                    queue.offer(new Pair(currNode.right, currColumn + 1));
//                }
//            }
//
//            for (int i = minColumn; i <= maxColumn; i++) {
//                res.add(columnToTreeNodes.get(i));
//            }
//
//            return res;
//
//
//        }
    }


}
