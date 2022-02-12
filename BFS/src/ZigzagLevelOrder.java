import java.util.*;

/**
 * LeetCode103
 * @author yanliu
 * @create 2021-03-24-23:13
 */
public class ZigzagLevelOrder {
    static class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            boolean isOdd = true;

            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Deque<TreeNode> subStack = new ArrayDeque<>();
                List<Integer> level = new ArrayList<>();

                while (!stack.isEmpty()) {
                    TreeNode curr = stack.pop();
                    level.add(curr.val);

                    if (!isOdd) {
                        if (curr.right != null) {
                            subStack.push(curr.right);
                        }

                        if (curr.left != null) {
                            subStack.push(curr.left);
                        }

                    } else {
                        if (curr.left != null) {
                            subStack.push(curr.left);
                        }

                        if (curr.right != null) {
                            subStack.push(curr.right);
                        }

                    }
                }

                stack = subStack;
                isOdd = !isOdd;
                res.add(level);
            }

            return res;
        }
    }

    static class Solution2 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isOdd = true;

            while (!queue.isEmpty()) {
                LinkedList<Integer> subRes = new LinkedList<>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (isOdd) {
                        subRes.add(curr.val);

                    } else {
                        subRes.addFirst(curr.val);
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }

                isOdd = !isOdd;
                res.add(subRes);
            }

            return res;
        }
    }
}
