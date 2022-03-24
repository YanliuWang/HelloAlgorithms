import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode1570
 * @author yanliu
 * @create 2022-03-21-6:46 PM
 */
public class DotProductOfTwoSparseVectors {
    static class Solution1 {
        class SparseVector {
            Map<Integer, Integer> indexToNum;

            SparseVector(int[] nums) {
                indexToNum = new HashMap<>();

                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        indexToNum.put(i, nums[i]);
                    }
                }
            }

            // Return the dotProduct of two sparse vectors
            public int dotProduct(SparseVector vec) {
                int res = 0;


                boolean isThisLess = this.indexToNum.size() < vec.indexToNum.size();
                int size = isThisLess ? this.indexToNum.size() : vec.indexToNum.size();

                if (isThisLess) {
                    res = getRes(this.indexToNum, vec.indexToNum);

                } else {
                    res = getRes(vec.indexToNum, this.indexToNum);

                }

                return res;
            }

            private int getRes(Map<Integer, Integer> vec1, Map<Integer, Integer> vec2) {
                int res = 0;

                for (Integer key : vec1.keySet()) {
                    if (vec2.containsKey(key)) {
                        res += vec1.get(key) * vec2.get(key);
                    }
                }

                return res;


            }
        }
    }

    static class Solution2 {
        class SparseVector {
            List<int[]> pairs;

            SparseVector(int[] nums) {
                pairs = new ArrayList<>();

                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        pairs.add(new int[]{i, nums[i]});
                    }
                }
            }

            // Return the dotProduct of two sparse vectors
            public int dotProduct(SparseVector vec) {
                List<int[]> pairs1 = this.pairs;
                List<int[]> pairs2 = vec.pairs;

                int p = 0, q = 0;
                int res = 0;

                while (p < pairs1.size() && q < pairs2.size()) {
                    if (pairs1.get(p)[0] == pairs2.get(q)[0]) {
                        res += pairs1.get(p)[1] * pairs2.get(q)[1];
                        p++;
                        q++;

                    } else if (pairs1.get(p)[0] > pairs2.get(q)[0]) {
                        q++;

                    } else {
                        p++;

                    }
                }

                return res;
            }
        }
    }

    /**
     * optimize the method using binary search
     */
    static class Solution3 {
        class SparseVector {
            List<int[]> pairs;

            SparseVector(int[] nums) {
                pairs = new ArrayList<>();

                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        pairs.add(new int[]{i, nums[i]});
                    }
                }
            }

            // Return the dotProduct of two sparse vectors
            public int dotProduct(SparseVector vec) {
                List<int[]> pairs1 = this.pairs;
                List<int[]> pairs2 = vec.pairs;

                int res = 0;

                if (pairs1.size() < pairs2.size()) {
                    res = getRes(pairs1, pairs2);

                } else {
                    res = getRes(pairs2, pairs1);

                }

                return res;
            }

            private int getRes(List<int[]> src, List<int[]> target) {
                int res = 0;

                for (int[] p : src) {
                    res += p[1] * binarySearch(p[0], target);

                }

                return res;
            }

            private int binarySearch(int index, List<int[]> target) {
                int left = 0;
                int right = target.size() - 1;

                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;

                    if (index == target.get(mid)[0]) {
                        return target.get(mid)[1];

                    } else if (index < target.get(mid)[0]) {
                        right = mid - 1;

                    } else {
                        left = mid + 1;

                    }
                }

                if (target.get(left)[0] == index) {
                    return target.get(left)[1];

                }

                if (target.get(right)[0] == index) {
                    return target.get(right)[1];

                }

                return 0;
            }
        }
    }

}
