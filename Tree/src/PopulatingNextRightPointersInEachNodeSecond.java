/**
 * LeetCode117
 * @author yanliu
 * @create 2020-11-11-14:58
 */
public class PopulatingNextRightPointersInEachNodeSecond {
    /**
     * iterative solution
     */
    static class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node firstNode = root;

            while (firstNode != null) {
                Node currAtLevel = firstNode;

                while (currAtLevel != null) {
                    if (currAtLevel.left != null) {
                        if (currAtLevel.right != null) {
                            currAtLevel.left.next = currAtLevel.right;

                        } else {
                            currAtLevel.left.next = getClosestChild(currAtLevel.next);

                        }
                    }

                    if (currAtLevel.right != null) {
                        currAtLevel.right.next = getClosestChild(currAtLevel.next);

                    }

                    currAtLevel = currAtLevel.next;
                }

                firstNode = getNextLevelFirst(firstNode);
            }

            return root;
        }

        private Node getClosestChild(Node node) {
            if (node == null) {
                return null;
            }

            return getNextLevelFirst(node);
        }

        private Node getNextLevelFirst(Node node) {
            while (node != null) {
                if (node.left != null) {
                    return node.left;
                }

                if (node.right != null) {
                    return node.right;
                }

                node = node.next;
            }

            return null;
        }

    }
}
