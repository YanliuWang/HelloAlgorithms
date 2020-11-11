/**
 * @author yanliu
 * @create 2020-11-11-14:58
 */
public class PopulatingNextRightPointersInEachNodeSecond {
    static class Solution {
        public Node construct(Node root) {
            if (root == null) {
                return null;
            }

            Node firstNodeAtLevel = root;

            while (firstNodeAtLevel != null) {
                Node currentNodeAtLevel = firstNodeAtLevel;

                while (currentNodeAtLevel != null) {
                    if (currentNodeAtLevel.left != null) {
                        if (currentNodeAtLevel.right != null) {
                            currentNodeAtLevel.left.next = currentNodeAtLevel.right;
                        } else {
                            currentNodeAtLevel.left.next = findClosestChildNode(currentNodeAtLevel);
                        }
                    }

                    if (currentNodeAtLevel.right != null) {
                        currentNodeAtLevel.right.next = findClosestChildNode(currentNodeAtLevel);
                    }

                    currentNodeAtLevel = currentNodeAtLevel.next;

                }

                firstNodeAtLevel = findNextLevelFirstNode(firstNodeAtLevel);

            }

            return root;
        }

        private Node findClosestChildNode(Node node) {
            if (node == null) {
                return null;
            }

            // looking for the node from next one
            node = node.next;

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


        private Node findNextLevelFirstNode(Node node) {
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
