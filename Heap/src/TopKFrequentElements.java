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
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToFreq = new HashMap<>();

            for (Integer num : nums) {
                numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            for (Integer num : numToFreq.keySet()) {
                int freq = numToFreq.get(num);

                if (minHeap.size() == k) {
                    if (minHeap.peek()[1] < freq) {
                        minHeap.poll();
                        minHeap.offer(new int[]{num, freq});
                    }

                } else {
                    minHeap.offer(new int[]{num, freq});
                }
            }



            int[] res = new int[k];

            for (int i = k - 1; i >= 0; i--) {
                res[i] = minHeap.poll()[0];
            }

            return res;
        }
    }
}
