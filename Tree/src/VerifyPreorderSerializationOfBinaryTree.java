import java.util.LinkedList;

/**
 * LeetCode331
 * @author yanliu
 * @create 2022-04-27-6:06 PM
 */
public class VerifyPreorderSerializationOfBinaryTree {
    static class Solution1 {
        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.length() == 0) {
                return false;
            }

            LinkedList<String> nodes = new LinkedList<>();

            for (String node : preorder.split(",")) {
                nodes.add(node);
            }

            return deserialize(nodes) && nodes.isEmpty();
        }

        private boolean deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return false;
            }

            String root = nodes.removeFirst();

            if (root.equals("#")) {
                return true;
            }

            return deserialize(nodes) && deserialize(nodes);
        }
    }

    static class Solution2 {
        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.length() == 0) {
                return false;
            }

            int edge = 1;

            for (String node : preorder.split(",")) {
                if ("#".equals(node)) {
                    edge -= 1;

                    if (edge < 0) {
                        return false;
                    }

                } else {
                    edge -= 1;

                    if (edge < 0) {
                        return false;
                    }

                    edge += 2;
                }
            }

            return edge == 0;
        }
    }
}
