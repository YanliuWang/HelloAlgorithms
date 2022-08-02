import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LintCode58
 * @author yanliu
 * @create 2022-08-01-5:47 PM
 */
public class FourSum {
    public class Solution {
        /**
         * @param numbers: Give an array
         * @param target: An integer
         * @return: Find all unique quadruplets in the array which gives the sum of zero
         *          we will sort your return value in output
         */
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            // write your code here
            List<List<Integer>> res = new ArrayList<>();

            if (numbers == null || numbers.length == 0) {
                return res;
            }

            Arrays.sort(numbers);

            for (int i = 0; i < numbers.length - 3; i++) {
                if (i != 0 && numbers[i] == numbers[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < numbers.length - 2; j++) {
                    if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                        continue;
                    }

                    int rest = target - (numbers[i] + numbers[j]);

                    int left = j + 1, right = numbers.length - 1;

                    while (left < right) {
                        int sum = numbers[left] + numbers[right];

                        if (sum == rest) {
                            List<Integer> subRes = new ArrayList<>();
                            subRes.add(numbers[i]);
                            subRes.add(numbers[j]);
                            subRes.add(numbers[left]);
                            subRes.add(numbers[right]);

                            res.add(subRes);

                            left++;
                            right--;

                            while (left < right && numbers[left] == numbers[left - 1]) {
                                left++;
                            }

                            while (left < right && numbers[right] == numbers[right + 1]) {
                                right--;
                            }

                        } else if (sum > rest) {
                            right--;

                        } else {
                            left++;

                        }
                    }
                }
            }

            return res;
        }
    }
}
