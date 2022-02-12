/**
 * @author yanliu
 * @create 2021-04-07-15:09
 */
public class BinarySearchTree {
    private boolean find(TreeNode root, int target) {
        TreeNode curr = root;

        while (curr != null) {
            if (target < root.val) {
                curr = curr.left;

            } else if (target > root.val) {
                curr = curr.right;

            } else {
                return true;

            }
        }

        return false;
    }

    private boolean add(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (value < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(value);
                    return true;
                }

                curr = curr.left;

            } else if (value > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(value);
                    return true;
                }

                curr = curr.right;

            } else {
                return false;
            }
        }

        return false;
    }

    private boolean remove(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            root = removeNode(root);
            return true;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (target < curr.val) {
                if (curr.left != null && curr.left.val != target) {
                    curr = curr.left;

                } else if (curr.left == null) {
                    return false;

                } else {
                    curr.left = removeNode(curr.left);
                    return true;
                }

            } else if (target > curr.val) {
                if (curr.right != null && curr.right.val != target) {
                    curr = curr.right;

                } else if (curr.right == null) {
                    return false;

                } else {
                    curr.right = removeNode(curr.right);
                    return true;
                }

            }
        }

        return false;
    }

    /**
     * remove the node and return new root
     * @param node
     * @return
     */
    private TreeNode removeNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;

        } else if (node.left == null) {
            return node.right;

        } else if (node.right == null) {
            return node.left;

        } else {
            node.val = removeNodeWithTwoChildren(node);
            return node;

        }
    }

    private int removeNodeWithTwoChildren(TreeNode node) {
        int result = 0;

        if (node.left.right == null) {
            result = node.left.val;
            node.left = node.left.left;
            return result;
        }

        TreeNode curr = node.left;

        while (curr.right.right != null) {
            curr = curr.right;
        }

        result = curr.right.val;

        curr.right = curr.right.left;

        return result;

    }
}
