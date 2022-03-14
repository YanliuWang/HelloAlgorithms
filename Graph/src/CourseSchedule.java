import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-23-11:24 AM
 */
public class CourseSchedule {
    /**
     * LeetCode210
     */
    static class Solution1 {
        /*
         * @param numCourses: a total of n courses
         * @param prerequisites: a list of prerequisite pairs
         * @return: the course order
         */
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // write your code here

            List<List<Integer>> graph = new ArrayList<>();
            int[] degree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            // build graph and get in degree of each node
            for (int i = 0; i < prerequisites.length; i++) {
                degree[prerequisites[i][0]]++;
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            // put 0 degree node to the queue
            for (int i = 0; i < numCourses; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }

            int index = 0;
            int[] res = new int[numCourses];

            while (!queue.isEmpty()) {
                int prerequisite = queue.poll();
                res[index] = prerequisite;
                index++;

                List<Integer> nextCourses = graph.get(prerequisite);

                for (Integer nextCourse : nextCourses) {
                    degree[nextCourse]--;

                    if (degree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

            // check if the topological sort exists
            if (index == numCourses) {
                return res;
            }

            return new int[0];


        }
    }

    /**
     * LeetCode207
     */
    static class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] degrees = new int[numCourses];

            // construct the graph
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] pre : prerequisites) {
                graph.get(pre[1]).add(pre[0]);
                degrees[pre[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            // put 0-degree nodes to queue first
            for (int i = 0; i < numCourses; i++) {
                if (degrees[i] == 0) {
                    queue.offer(i);
                }
            }

            int removeNodes = 0;

            while (!queue.isEmpty()) {
                int currCourse = queue.poll();
                removeNodes++;

                List<Integer> nextCourses = graph.get(currCourse);

                for (Integer nextCourse : nextCourses) {
                    degrees[nextCourse]--;

                    if (degrees[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }

            }

            return removeNodes == numCourses;


        }
    }

    /**
     * LeetCode630
     */
    static class Solution3_1 {
        public int scheduleCourse(int[][] courses) {
            // sort the courses in ascending order
            // based on the last day
            Arrays.sort(courses, new Comparator<>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });

            // construct the memo array
            int[][] memo =
                    new int[courses.length][courses[courses.length - 1][1] + 1];
            for (int[] arr : memo) {
                Arrays.fill(arr, -1);
            }

            return scheduleCourse(courses, 0, 0, memo);

        }

        private int scheduleCourse(int[][] courses, int curr,
                                   int time, int[][] memo) {
            int n = courses.length;

            if (curr == courses.length) {
                return 0;
            }

            if (memo[curr][time] != -1) {
                return memo[curr][time];
            }

            int taken = 0;
            if (courses[curr][0] + time <= courses[curr][1]) {
                taken = 1 + scheduleCourse(courses, curr + 1, time + courses[curr][0], memo);
            }

            int notTaken = scheduleCourse(courses, curr + 1, time, memo);

            memo[curr][time] = Math.max(taken, notTaken);

            return memo[curr][time];
        }
    }

    static class Solution3_2 {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, new Comparator<>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });


            int time = 0;
            int count = 0;

            for (int i = 0; i < courses.length; i++) {
                if (time + courses[i][0] <= courses[i][1]) {
                    // current course can be taken
                    time += courses[i][0];
                    count++;

                } else {
                    // current course cannot be taken

                    // find the previous course with maximum duration
                    int maxPrev = i;

                    for (int j = 0; j < i; j++) {
                        if (courses[j][0] > courses[maxPrev][0]) {
                            maxPrev = j;
                        }
                    }

                    if (courses[maxPrev][0] > courses[i][0]) {
                        // replace the max previous course with current course
                        time -= courses[maxPrev][0] - courses[i][0];
                    }

                    courses[maxPrev][0] = -1;

                }
            }

            return count;

        }
    }

    static class Solution3_3co {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, new Comparator<>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });

            int time = 0;
            for (int[] course : courses) {
                if (course[0] + time <= course[1]) {
                    time += course[0];
                    maxHeap.offer(course[0]);

                } else if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                    time -= maxHeap.poll() - course[0];
                    maxHeap.offer(course[0]);
                }
            }

            return maxHeap.size();
        }
    }
}
