import java.util.*;

/**
 * @author yanliu
 * @create 2021-04-18-21:48
 */
public class TopNNumers {
    public List<Integer> topNumbers(int[][] numbers) {
        int m = numbers.length;
        int n = numbers[0].length;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
        for (int i: numbers[0]) {
            minHeap.add(i);
        }

        int[] list = new int[n];

        for (int i = 1; i < m; i ++) {
            for (int j = n - 1; j >= 0; j --) {
                list[j] = minHeap.poll();
            }

            Integer[] cur = new Integer[numbers[i].length];

            for (int k = 0; k < numbers[i].length; k++) {
                cur[k] = numbers[i][k];
            }

            Arrays.sort(cur, Collections.reverseOrder());
            int largest = cur[0];
            for (int j = 0; j < n; j ++) {
                minHeap.add(largest + list[j]);
            }
            for (int j = 1; j < n; j ++) {
                for (int r = 0; r < n ; r ++) {
                    if (cur[j] + list[r] < minHeap.peek()) {
                        break; }
                    minHeap.poll();
                    minHeap.add(cur[j] + list[r]);
                } } }
        List<Integer> result = new ArrayList<>();
        result.addAll(minHeap);
        Collections.sort(result, comparator);
        return result;
    }

}
