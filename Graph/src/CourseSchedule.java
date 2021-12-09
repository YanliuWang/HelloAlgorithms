import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 210
 * @author yanliu
 * @create 2021-10-23-11:24 AM
 */
public class CourseSchedule {
    class Solution1 {
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
}
