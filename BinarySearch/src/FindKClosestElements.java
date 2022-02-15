import java.util.ArrayList;
import java.util.List;

/**
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

            int left = 0, right = arr.length - 1;
            int index = 0;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == x) {
                    index = mid;
                    break;

                } else if (arr[mid] > x) {
                    right = mid;

                } else {
                    left = mid;

                }
            }

            // get the closest number
            if (left + 1 == right) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    index = left;

                } else {
                    index = right;

                }
            }

            left = index;
            right = index + 1;

            while (left >= 0 && right < arr.length && k > 0) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    left--;

                } else {
                    right++;

                }

                k--;
            }

            while (left >= 0 && k > 0) {
                left--;
                k--;
            }

            while (right < arr.length && k > 0) {
                right++;
                k--;
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
