import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode272
 * @author yanliu
 * @create 2022-04-03-3:27 PM
 */
public class ClosestBinarySearchTreeValueII {
    static class Solution1 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> res = new ArrayList<>(k);

            if (root == null) {
                return res;
            }

            List<Integer> inorder = new ArrayList<>();
            getInorder(root, inorder);

            int left = 0, right = inorder.size() - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target == inorder.get(mid)) {
                    right = mid;

                } else if (target > inorder.get(mid)) {
                    left = mid;

                } else {
                    right = mid;

                }
            }

            while (right - left - 1 < k) {
                if (left == -1) {
                    right++;
                    continue;
                }

                if (right == inorder.size()
                        || (Math.abs(inorder.get(left) - target) <= Math.abs(inorder.get(right) - target))) {
                    left--;

                } else {
                    right++;

                }
            }

            for (int i = left + 1; i < right; i++) {
                res.add(inorder.get(i));
            }

            return res;
        }

        private void getInorder(TreeNode root, List<Integer> inorder) {
            if (root == null) {
                return;
            }

            getInorder(root.left, inorder);
            inorder.add(root.val);
            getInorder(root.right, inorder);
        }
    }

    static class Solution2 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Deque<Integer> queue = new ArrayDeque<>();

            getInorder(root, target, k, queue);

            return new ArrayList<>(queue);
        }

        private void getInorder(TreeNode root, double target, int k, Deque<Integer> queue) {
            if (root == null) {
                return;
            }

            getInorder(root.left, target, k, queue);

            if (queue.size() == k) {
                if (Math.abs(Double.valueOf(queue.peek()) - target)
                        > Math.abs(Double.valueOf(root.val) - target)) {
                    queue.poll();
                    queue.offer(root.val);

                } else {
                    return;

                }

            } else {
                queue.offer(root.val);

            }

            getInorder(root.right, target, k, queue);
        }
    }

    static class Solution3 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            if (root == null) {
                return new ArrayList<>();
            }

            Deque<Integer> predecessors = new ArrayDeque<>();
            Deque<Integer> successors = new ArrayDeque<>();

            inorder(root, target, k, false, predecessors);
            inorder(root, target, k, true, successors);

            List<Integer> res = new ArrayList<>(k);

            while (k > 0) {
                if (predecessors.isEmpty()) {
                    res.add(successors.pop());

                } else if (successors.isEmpty()) {
                    res.add(predecessors.pop());

                } else if (Math.abs(Double.valueOf(predecessors.peek() - target))
                        <= Math.abs(Double.valueOf(successors.peek() - target))) {
                    res.add(predecessors.pop());

                } else {
                    res.add(successors.pop());

                }

                k--;
            }

            return res;
        }

        private void inorder(TreeNode root, double target, int k,
                             boolean reverse, Deque<Integer> stack) {
            if (root == null) {
                return;
            }

            inorder(reverse ? root.right : root.left, target, k, reverse, stack);

            if ((reverse && root.val <= target) || (!reverse && root.val > target)) {
                return;
            }

            stack.push(root.val);

            inorder(reverse ? root.left : root.right, target, k, reverse, stack);
        }
    }
}
