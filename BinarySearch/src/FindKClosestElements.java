import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode658
 * @author yanliu
 * @create 2022-02-14-5:20 PM
 */
public class FindKClosestElements {
    static class Solution1 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();

            if (arr == null || arr.length == 0) {
                return res;
            }

            int start = 0, end = arr.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] <= x) {
                    start = mid;

                } else {
                    end = mid - 1;

                }
            }

            int left = 0;

            if (arr[end] <= x) {
                left = end;

            } else if (arr[start] <= x) {
                left = start;

            }

            int right = left + 1;

            while (right - left - 1 < k) {
                if (left == -1) {
                    right++;

                } else if (right == arr.length) {
                    left--;

                } else {
                    if (x - arr[left] <= arr[right] - x) {
                        left--;

                    } else {
                        right++;

                    }

                }
            }

            for (int i = left + 1; i < right; i++) {
                res.add(arr[i]);
            }

            return res;
        }
    }

    static class Solution2 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();

            if (arr == null || arr.length < k) {
                return res;
            }

            // find the left bound of scope
            int left = 0, right = arr.length - k;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid + k] - x < x - arr[mid]) {
                    left = mid + 1;

                } else {
                    right = mid;
                }
            }

            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }

            return res;

        }
    }
}
