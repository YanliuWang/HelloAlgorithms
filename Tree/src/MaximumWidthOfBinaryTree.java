import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode662
 * @author yanliu
 * @create 2022-05-16-5:49 PM
 */
public class MaximumWidthOfBinaryTree {
    class Solution1 {
        class Node {
            TreeNode node;
            int index;

            public Node(TreeNode node, int index) {
                this.node = node;
                this.index = index;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));

            int maxWidth = 0;

            while (!queue.isEmpty()) {
                Node head = queue.peek();
                int size = queue.size();
                Node tail = null;

                for (int i = 0; i < size; i++) {
                    tail = queue.poll();
                    TreeNode curr = tail.node;

                    if (curr.left != null) {
                        queue.offer(new Node(tail.node.left, tail.index * 2));
                    }

                    if (curr.right != null) {
                        queue.offer(new Node(tail.node.right, tail.index * 2 + 1));
                    }
                }

                maxWidth = Math.max(maxWidth, tail.index - head.index + 1);
            }

            return maxWidth;
        }
    }

    class Solution2 {
        List<Integer> firstIds = new ArrayList<>();
        int maxWidth = 1;

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            traverse(root, 0, 0);

            return maxWidth;
        }

        private void traverse(TreeNode node, int id, int depth) {
            if (node == null) {
                return;
            }

            if (firstIds.size() == depth) {
                firstIds.add(id);

            } else {
                maxWidth = Math.max(maxWidth, id - firstIds.get(depth) + 1);

            }

            traverse(node.left, id * 2, depth + 1);
            traverse(node.right, id * 2 + 1, depth + 1);
        }
    }
}
