import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 * where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * @author yanliu
 * @create 2022-03-19-11:33 PM
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        if (arr == null || arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int rest = target - arr[i];

            count += getCount(arr, i, rest);

        }
        return count;
    }

    private static int getCount(int[] arr, int i, int target) {
        int left = i + 1;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                count += right - left;
                left++;

                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }

            } else {
                right--;

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;

                }
            }
        }

        return count;
    }
}
