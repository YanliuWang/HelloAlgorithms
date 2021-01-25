import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC508
 * @author yanliu
 * @create 2021-01-25-15:35
 */
public class MostFrequentSubtreeSum {
    static class Solution {
        private int maxFreq = 0;
        private Map<Integer, Integer> sumToFreq = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            List<Integer> resList = new ArrayList<>(sumToFreq.size());

            findMaxSum(root);

            for (Integer sum : sumToFreq.keySet()) {
                if (sumToFreq.get(sum) == maxFreq) {
                    resList.add(sum);
                }
            }

            int[] resArray = new int[resList.size()];

            for (int i = 0; i < resArray.length; i++) {
                resArray[i] = resList.get(i);
            }

            return resArray;



        }

        // get the max sum of tree rooted in node
        private int findMaxSum(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftMax = findMaxSum(node.left);
            int rightMax = findMaxSum(node.right);
            int sum = node.val + leftMax + rightMax;

            int freq = sumToFreq.getOrDefault(sum, 0) + 1;

            sumToFreq.put(sum, freq);

            maxFreq = freq > maxFreq ? freq : maxFreq;

            return sum;
        }
    }
}
