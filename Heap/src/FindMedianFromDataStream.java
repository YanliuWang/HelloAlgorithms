import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode295
 * @author yanliu
 * @create 2021-04-18-21:44
 */
public class FindMedianFromDataStream {
    static class Solution {
        // we store right side numbers in the min heap
        private PriorityQueue<Integer> minHeap;

        // we store the left side numbers in the max heap
        private PriorityQueue<Integer> maxHeap;

        /** initialize your data structure here. */
        public Solution() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }

            });
        }

        public void addNum(int num) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);

            } else {
                maxHeap.offer(num);

            }

            // we need to maintain the size of both sides
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());

            }

            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }

        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek() * 1.0;

            } else if (minHeap.size() < maxHeap.size()) {
                return maxHeap.peek() * 1.0;

            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;

            }

        }
    }

    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        private boolean even;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
            even = true;
        }

        public void addNum(int num) {
            if (even) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }

            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;

            } else {
                return maxHeap.peek() * 1.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
