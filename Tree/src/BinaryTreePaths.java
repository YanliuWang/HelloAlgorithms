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
    static class Solution1 {
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
    static class Solution2 {
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
}
