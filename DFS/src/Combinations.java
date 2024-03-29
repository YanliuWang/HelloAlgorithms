import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode77
 * @author yanliu
 * @create 2021-01-26-21:29
 */
public class Combinations {
    static class Solution1 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n < k) {
                return res;
            }

            List<Integer> tmp = new LinkedList<>();

            backTrack(tmp, n, k, 1);

            return res;
        }

        private void backTrack(List<Integer> tmp, int n, int remain, int start) {
            if (remain == 0) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i <= n-remain+1; i++) {
                tmp.add(i);

                backTrack(tmp, n, remain-1, i+1);

                tmp.remove(tmp.size() - 1);
            }
        }
    }

    static class Solution2 {
        public List<List<Integer>> combine(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            combination(results, nums, 0, new ArrayList<Integer>());
            return results;
        }

        public void combination(List<List<Integer>> results,
                                       int[] nums, int index,
                                       ArrayList<Integer> items) {
            if (index == nums.length) {
                results.add(new ArrayList<Integer>(items));
                return;
            }

            for (int i = index; i < nums.length; i++) {
                items.add(nums[i]);
                combination(results, nums, i+1, items);
                items.remove(items.size()-1);
            }

            combination(results, nums, nums.length, items);
        }

        public static void main(String[] args) {
            List<List<Integer>> combine = new Solution2().combine(new int[]{2, 6, 8});

            for (List<Integer> list : combine) {
                System.out.println(list);
            }
        }
    }

    static class Solution3 {
        public List<List<Integer>> combine(int n, int k) {
            // store the final results
            List<List<Integer>> res = new ArrayList<>();

            // store the current result
            List<Integer> path = new ArrayList<>();

            // do backtrack
            backtrack(n, k, res, path, 1);

            return res;

        }

        private void backtrack(int n, int k, List<List<Integer>> res, List<Integer> path, int start) {
            // end condition
            if (path.size() == k) {
                // add the current result to the final results
                res.add(new ArrayList<>(path));
                return;
            }

            // for-loop select current layer
            // i 为开始遍历的初始位置
            // i 至多从 n - (k - path.size()) + 1 开始遍历
            for (int i = start; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);

                backtrack(n, k, res, path, i + 1);

                path.remove(path.size() - 1);
            }



        }
    }
}
