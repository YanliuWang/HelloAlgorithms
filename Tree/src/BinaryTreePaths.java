import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 257
 * @author yanliu
 * @create 2021-01-16-15:10
 */
public class BinaryTreePaths {
    /**
     * traverse
     */
    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();

            constructPaths(root, "", paths);

            return paths;
        }

        private void constructPaths(TreeNode root, String currSeq, List<String> paths) {
            if (root == null) {
                return;
            }

            // get a deep copy values instead of reference
            StringBuilder sb = new StringBuilder(currSeq);
            sb.append(root.val);

            if (root.left == null && root.right == null) {
                paths.add(sb.toString());

            } else {
                sb.append("->");

                constructPaths(root.left, currSeq, paths);
                constructPaths(root.right, currSeq, paths);
            }
        }
    }

    /**
     * divide and conquer
     */
    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            if (root.left == null && root.right == null) {
                res.add(String.valueOf(root.val));
                return res;
            }

            List<String> leftPaths = binaryTreePaths(root.left);
            List<String> rightPaths = binaryTreePaths(root.right);

            for (String path : leftPaths) {
                res.add(root.val + "->" + path);
            }

            for (String path : rightPaths) {
                res.add(root.val + "->" + path);
            }

            return res;
        }

    }

    /**
     * using StringBuilder
     */
    class Solution3 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            dfs(root, new StringBuilder(), res);

            return res;
        }

        private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
            if (root.left == null && root.right == null) {
                sb.append(root.val);
                res.add(sb.toString());
                return;
            }

            if (root.left != null) {
                String prev = sb.toString();
                sb.append(root.val).append("->");

                dfs(root.left, sb, res);

                sb = new StringBuilder(prev);
            }

            if (root.right != null) {
                sb.append(root.val).append("->");
                dfs(root.right, sb, res);
            }
        }
    }
}
