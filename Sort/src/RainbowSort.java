package rainbowsort;

/**Question : 给定一个数组{-1,1,0,-1,0,1} 数组中只有确定的3种重复元素-1,0,1，设计一个算法将其排列成{-1,-1,0,0,1,1}。
 * Solution : i j k 分割出四个部分，[0, i) 为 -1, [i, j) 为 0, [j, k) 为不确定部分，[k, arr.length-1) 1
 * @author yanliu
 * @create 2021-02-18-12:06
 */
public class RainbowSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int i = 0, j = 0, k = arr.length - 1;

        while (j <= k) {
            if (arr[j] == -1) {
                swap(arr, i, j);
                i++;
                j++;

            } else if (arr[j] == 0) {
                j++;

            } else if (arr[j] == 1){
                swap(arr, j, k);
                k--;

            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 0, 0, 1, 1};
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
