import java.util.LinkedList;
import java.util.List;

/**
 * LC257
 * @author yanliu
 * @create 2021-01-16-15:10
 */
public class BinaryTreePaths {
    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();

            constructPaths(root, "", paths);

            return paths;
        }

        private void constructPaths(TreeNode root, String currSeq, List<String> paths) {
            if (root == null) {
                return;
            }

            StringBuilder sb = new StringBuilder(currSeq);
            sb.append(Integer.toString(root.val));

            if (root.left == null && root.right == null) {
                paths.add(sb.toString());

            } else {
                sb.append("->");

                constructPaths(root.left, currSeq, paths);
                constructPaths(root.right, currSeq, paths);
            }
        }
    }
}
