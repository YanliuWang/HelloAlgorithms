/**
 * @author yanliu
 * @create 2022-02-08-8:01 PM
 */
public class DifferenceArray {
    private int[] diff;

    public DifferenceArray(int[] nums) {
        diff = getDiffArray(nums);
    }

    /**
     * construct difference array
     * @param nums
     * @return
     */
    private int[] getDiffArray(int[] nums) {
        int[] diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        return diff;
    }

    /**
     * increase val to the elements between [i, j]
     * @param i
     * @param j
     * @param val
     */
    private void increaseArray(int i, int j, int val) {
        diff[i] += val;

        if (j + 1 < diff.length) {
            diff[j + 1] -= val;

        }
    }

    /**
     * get the final array based on the diff array
     * @param diff
     * @return
     */
    private int[] getArray(int[] diff) {
        int[] res = new int[diff.length];
        res[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;

    }



}
