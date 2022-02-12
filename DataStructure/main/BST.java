/**
 * @author yanliu
 * @create 2022-01-09-10:02 PM
 */
public class BST {
    private boolean find(TreeNode root, int target) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > target) {
                curr = curr.left;

            } else if (curr.val < target) {
                curr = curr.right;

            } else {
                return true;
            }
        }

        return false;
    }

    private boolean add(TreeNode root, int value) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > value) {
                if (curr.left == null) {
                    curr.left = new TreeNode(value);
                    return true;

                } else {
                    curr = curr.left;

                }

            } else if (curr.val < value) {
                if (curr.right == null) {
                    curr.right = new TreeNode(value);
                    return true;

                } else {
                    curr = curr.right;

                }

            } else {
                return false;

            }
        }

        return false;
    }

    private boolean remove(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            root = removeNode(root);
            return true;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > value) {
                if (curr.left != null && curr.left.val == value) {
                    curr.left = removeNode(curr.left);
                    return true;

                } else if (curr.left != null) {
                    curr = curr.left;

                } else {
                    return false;
                }

            } else if (curr.val < value) {
                if (curr.right != null && curr.right.val == value) {
                    curr.right = removeNode(curr.right);
                    return true;

                } else if (curr.right != null) {
                    curr = curr.right;

                } else {
                    return false;
                }

            } else {
                return false;

            }
        }

        return false;
    }

    private TreeNode removeNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;

        } else if (node.left == null) {
            return node.right;

        } else if (node.right == null) {
            return node.left;

        } else {
            node.val = removeNodeWithTwoChildren(node);

        }

        return node;
    }

    private int removeNodeWithTwoChildren(TreeNode node) {
        int value = 0;

        if (node.left.right == null) {
            value = node.left.val;
            node.left = node.left.left;

            return value;
        }

        TreeNode curr = node.left;

        while (curr.right.right != null) {
            curr = node.right;
        }

        curr.right = curr.right.left;
        value = curr.right.val;

        return value;
    }
}
