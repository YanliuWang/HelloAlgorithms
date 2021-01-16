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

            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }

            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }

    }
    /**
     * LC113 : path sum II
     */
    static class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            _helper(root, sum, new ArrayList<>(), res);

            return res;
        }

        private void _helper(TreeNode node, int target, List<Integer> curSeq, List<List<Integer>> res) {
            curSeq.add(node.val);

            if (node.left == null && node.right == null && node.val == target) {
                res.add(new ArrayList<>(curSeq));
            }

            if (node.left != null) {
                _helper(node.left, target-node.val, curSeq, res);
            }

            if (node.right != null) {
                _helper(node.right, target-node.val, curSeq, res);
            }

            curSeq.remove(curSeq.size()-1);
        }
    }

    /**
     * LC437 : path sum III
     */
    static class Solution3 {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> prefixSumToFreq = new HashMap<>();

            // put pre-root pair
            prefixSumToFreq.put(0, 1);

            return _helper(root, prefixSumToFreq, 0, sum);
        }

        private int _helper(TreeNode root, Map<Integer, Integer> prefixSumToFreq, int currSum, int target) {
            // 1.递归终止条件
            if (root == null) {
                return 0;
            }

            // 2.本层要做的事
            // 当前路径上的和
            currSum += root.val;

            // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
            // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
            // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
            int res = prefixSumToFreq.getOrDefault(currSum - target, 0);

            // 更新路径上当前节点前缀和的个数
            prefixSumToFreq.put(currSum, prefixSumToFreq.getOrDefault(currSum, 0) + 1);

            // 3.下探到下一层
            res += _helper(root.left, prefixSumToFreq, currSum, target)
                    + _helper(root.right, prefixSumToFreq, currSum, target);

            // 4.回到本层，恢复状态，去除当前节点的前缀和数量
            prefixSumToFreq.put(currSum, prefixSumToFreq.get(currSum) - 1);

            return res;
        }
    }
}
