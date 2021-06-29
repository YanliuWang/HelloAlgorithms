/**
 * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，
 * 将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
 * You are not suppose to use the library's sort function for this problem.
 * k <= n
 * @author yanliu
 * @create 2021-02-18-11:29
 */
public class SortColor {
    public static void sort(int[] color, int k) {
        if (color == null || color.length == 0) {
            return;
        }

        sort(color, 0, color.length-1, 1, k);
    }

    private static void sort(int[] color, int lo, int hi, int colorFrom, int colorTo) {
        if (colorTo <= colorFrom) {
            return;
        }

        if (hi <= lo) {
            return;
        }

        // find the mid color
        int colorMid = colorFrom + (colorTo - colorFrom) / 2;

        int start = lo, end = hi;

        while (start <= end) {
            while (start <= end && color[start] <= colorMid) {
                start++;
            }

            while (start <= end && color[end] >= colorMid) {
                end--;
            }

            if (start <= end) {
                int tmp = color[start];
                color[start] = color[end];
                color[end] = tmp;

                start++;
                end--;
            }

        }

        sort(color, lo, end, colorFrom, colorMid);
        sort(color, start, hi, colorMid + 1, colorTo);
    }

    public static void main(String[] args) {
        int[] colors = new int[]{3, 2, 2, 1, 4};
        int k = 4;

        sort(colors, k);

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }
}
