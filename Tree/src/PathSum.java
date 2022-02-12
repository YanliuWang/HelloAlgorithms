import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanliu
 * @create 2020-11-06-9:56
 */
public class PathSum {
    /**
     * LC112 : path sum I
     */
    static class Solution1 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    return true;
                }

                return false;
            }

            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }

    }
    /**
     * LC113 : path sum II
     */
    static class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            dfs(root, targetSum, new ArrayList<>(), res);

            return res;
        }

        private void dfs(TreeNode root, int targetSum,
                         List<Integer> curr, List<List<Integer>> res) {
            curr.add(root.val);

            if (root.left == null && root.right == null && root.val == targetSum) {
                res.add(new ArrayList<>(curr));
            }

            if (root.left != null) {
                dfs(root.left, targetSum - root.val, curr, res);
            }

            if (root.right != null) {
                dfs(root.right, targetSum - root.val, curr, res);
            }

            curr.remove(curr.size() - 1);
        }
    }

    /**
     * LC437 : path sum III
     */
    static class Solution3 {
        private int res = 0;
        private Map<Integer, Integer> sumToFreq = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            dfs(root, 0, targetSum);

            return res;
        }

        private void dfs(TreeNode root, int currSum, int targetSum) {
            if (root == null) {
                return;
            }

            currSum += root.val;

            if (currSum == targetSum) {
                res++;
            }

            res += sumToFreq.getOrDefault(currSum - targetSum, 0);

            sumToFreq.put(currSum, sumToFreq.getOrDefault(currSum, 0) + 1);

            dfs(root.left, currSum, targetSum);
            dfs(root.right, currSum, targetSum);

            sumToFreq.put(currSum, sumToFreq.get(currSum) - 1);
        }
    }
}
