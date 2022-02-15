import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC297
 * @author yanliu
 * @create 2020-12-19-23:28
 */
public class SerializeAndDeserialize {
    /**
     * 前序遍历序列化和反序列化
     */
    static class Solution1 {
        private String SEP = ",";
        private String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root){
            StringBuilder sb = new StringBuilder();

            serialize(root, sb);

            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            // preorder traverse
            sb.append(root.val).append(SEP);

            serialize(root.left, sb);
            serialize(root.right, sb);
        }


        // Decodes your encoded data to tree.

        public TreeNode deserialize(String data){
            return deserialize(new LinkedList<>(Arrays.asList(data.split(SEP))));
        }

        public TreeNode deserialize(LinkedList<String> data) {
            if (data.isEmpty()) {
                return null;
            }

            String first = data.removeFirst();

            if (first.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(first));

            root.left = deserialize(data);
            root.right = deserialize(data);

            return root;

        }
    }

    /**
     * 后序遍历序列化和反序列化
     */
    static class Solution2 {
        private final String SEP = ",";
        private final String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            serialize(root, sb);

            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            serialize(root.left, sb);
            serialize(root.right, sb);

            sb.append(root.val).append(SEP);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize(new LinkedList<>(Arrays.asList(data.split(SEP))));
        }

        private TreeNode deserialize(LinkedList<String> data) {
            if (data.isEmpty()) {
                return null;
            }

            String node = data.removeLast();

            if (node.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(node));

            root.right = deserialize(data);
            root.left = deserialize(data);

            return root;
        }
    }


    /**
     * 层序遍历序列化和反序列化
     */
    static class Solution3 {
        private String SEP = ",";
        private String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();

                if (curr == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }

                sb.append(curr.val).append(SEP);

                queue.offer(curr.left);
                queue.offer(curr.right);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> dataQueue = new LinkedList<>(Arrays.asList(data.split(SEP)));
            Queue<TreeNode> treeQueue = new LinkedList<>();

            if (dataQueue.isEmpty() || NULL.equals(dataQueue.peek())) {
                return null;
            }


            TreeNode root = new TreeNode(Integer.parseInt(dataQueue.poll()));
            treeQueue.offer(root);

            while (!treeQueue.isEmpty()) {
                TreeNode parent = treeQueue.poll();

                String left = dataQueue.poll();
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    treeQueue.offer(parent.left);
                } else {
                    parent.left = null;
                }

                String right = dataQueue.poll();
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    treeQueue.offer(parent.right);
                } else {
                    parent.right = null;
                }

            }

            return root;

        }
    }
}
