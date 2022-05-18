import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode 347
 * @author yanliu
 * @create 2021-12-03-9:45 AM
 */
public class TopKFrequentElements {
    static class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return new int[0];
            }

            Map<Integer, Integer> numToFreq = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                numToFreq.put(nums[i], numToFreq.getOrDefault(nums[i], 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (o1, o2) -> numToFreq.get(o1) - numToFreq.get(o2));


            for (int num : numToFreq.keySet()) {
                pq.offer(num);

                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] res = new int[k];

            for (int i = 0; i < res.length; i++) {
                res[i] = pq.poll();
            }

            return res;


        }
    }

    static class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return new int[0];
            }

            Map<Integer, Integer> numToFreq = new HashMap<>();
            for (int num : nums) {
                numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
            }

            int n = numToFreq.size();
            int[] unique = new int[n];
            int index = 0;
            for (int num : numToFreq.keySet()) {
                unique[index++] = num;
            }

            quickSelect(unique, 0, n - 1, k, numToFreq);

            int[] res = new int[k];

            for (int i = 0; i < k; i++) {
                res[i] = unique[i];
            }

            return res;
        }

        private void quickSelect(int[] nums, int start, int end, int k,
                                 Map<Integer, Integer> numToFreq) {
            if (start == end) {
                return;
            }

            int left = start, right = end;
            int pivot = nums[left + (right - left) / 2];

            while (left <= right) {
                while (left <= right
                        && numToFreq.get(nums[left]) > numToFreq.get(pivot)) {
                    left++;
                }

                while (left <= right
                        && numToFreq.get(nums[right]) < numToFreq.get(pivot)) {
                    right--;
                }

                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;

                    left++;
                    right--;
                }
            }

            if (start + k - 1 <= right) {
                quickSelect(nums, start, right, k, numToFreq);

            } else if (start + k - 1 >= left) {
                quickSelect(nums, left, end, k - (left - start), numToFreq);

            }

        }
    }
}
