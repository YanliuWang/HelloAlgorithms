import java.util.Arrays;

/**
 * lintcode 382
 * @author yanliu
 * @create 2021-07-01-21:21
 */
public class TriangleCount {
    class Solution {
        /**
         * @param S: A list of integers
         * @return: An integer
         */
        public int triangleCount(int[] S) {
            // write your code here
            if (S == null || S.length < 3) {
                return 0;
            }

            // sort the array in increasing order
            Arrays.sort(S);

            // total count of triangles
            int count = 0;

            for (int i = 2; i < S.length; i++) {
                int target = S[i];
                int left = 0, right = i - 1;

                count += getTwoSum(S, left, right, target);
            }

            return count;
        }

        private int getTwoSum(int[] S, int left, int right, int target) {
            //get two sum(> target) count
            int count = 0;

            while (left < right) {
                int sum = S[left] + S[right];

                if (sum > target) {
                    count += right - left;

                    // move the right to get smaller edges
                    right--;

                } else {
                    left++;

                }
            }

            return count;
        }
    }
}
