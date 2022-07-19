import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/smallest-difference
 * @author yanliu
 * @create 2022-06-13-9:46 AM
 */
public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        if (arrayOne == null || arrayOne.length == 0
                || arrayTwo == null || arrayTwo.length == 0) {
            return new int[0];
        }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int p1 = 0, p2 = 0;
        int diff = Integer.MAX_VALUE;
        int[] res = new int[2];

        while (p1 < arrayOne.length && p2 < arrayTwo.length) {
            int currDiff = Math.abs(arrayOne[p1] - arrayTwo[p2]);

            if (diff > currDiff) {
                diff = currDiff;
                res[0] = arrayOne[p1];
                res[1] = arrayTwo[p2];

            }

            if (arrayOne[p1] < arrayTwo[p2]) {
                p1++;

            } else if (arrayOne[p1] > arrayTwo[p2]) {
                p2++;

            } else {
                return new int[]{arrayOne[p1], arrayTwo[p2]};

            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arr2 = new int[]{26, 134, 135, 15, 17};


        int[] res = smallestDifference(arr1, arr2);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
