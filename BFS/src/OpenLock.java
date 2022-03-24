import java.util.*;

/**
 * @author yanliu
 * @create 2022-03-22-10:09 PM
 */
public class OpenLock {
    static class Solution1 {
        public int openLock(String[] deadends, String target) {
            String s = "0000";

            Set<String> deads = new HashSet<>();
            for (String deadend : deadends) {
                deads.add(deadend);
            }

            if (deads.contains(s)) {
                return -1;
            }

            Map<String, Integer> strToTurns = new HashMap<>();

            Queue<String> queue = new LinkedList<>();
            queue.offer(s);
            strToTurns.put(s, 0);

            while (!queue.isEmpty()) {
                // "0000" -> "1000" -> ""
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return strToTurns.get(curr);
                }

                // get next moves
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(curr, i);

                    if (!strToTurns.containsKey(up) && !deads.contains(up)) {
                        strToTurns.put(up, strToTurns.get(curr) + 1);
                        queue.offer(up);
                    }

                    String down = minusOne(curr, i);

                    if (!strToTurns.containsKey(down) && !deads.contains(down)) {
                        strToTurns.put(down, strToTurns.get(curr) + 1);
                        queue.offer(down);
                    }
                }
            }

            return -1;
        }

        private String plusOne(String curr, int index) {
            char[] arr = curr.toCharArray();

            if (arr[index] == '9') {
                arr[index] = '0';

            } else {
                arr[index] += 1;

            }

            return new String(arr);
        }

        private String minusOne(String curr, int index) {
            char[] arr = curr.toCharArray();

            if (arr[index] == '0') {
                arr[index] = '9';

            } else {
                arr[index] -= 1;

            }

            return new String(arr);
        }

    }

    static class Solution2 {
        public int openLock(String[] deadends, String target) {
            Set<String> deads = new HashSet<>();

            for (String dead : deadends) {
                deads.add(dead);
            }

            String start = "0000";
            if (deads.contains(start)) {
                return -1;
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(start);

            Set<String> visited = new HashSet<>();
            visited.add(start);

            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();

                    if (curr.equals(target)) {
                        return step;
                    }

                    List<String> neighbors = getNeighbors(curr);

                    for (String neighbor : neighbors) {
                        if (visited.contains(neighbor)) {
                            continue;
                        }

                        if (deads.contains(neighbor)) {
                            continue;
                        }

                        queue.offer(neighbor);
                        visited.add(neighbor);

                    }
                }

                step++;
            }

            return -1;

        }

        private List<String> getNeighbors(String curr) {
            List<String> res = new ArrayList<>();
            char[] arr = curr.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];

                arr[i] = ch == '9' ? '0' : (char) (ch + 1);
                res.add(String.valueOf(arr));

                arr[i] = ch == '0' ? '9' : (char) (ch - 1);
                res.add(String.valueOf(arr));

                arr[i] = ch;
            }

            return res;
        }
    }

    static class Solution3 {
        public int openLock(String[] deadends, String target) {
            String start = "0000";

            Set<String> deads = new HashSet<>();
            for (String dead : deadends) {
                deads.add(dead);
            }

            if (deads.contains(start)) {
                return -1;
            }

            Map<String, Integer> strToTurns = new HashMap<>();
            strToTurns.put(start, 0);

            Queue<String> queue = new LinkedList<>();
            queue.offer(start);

            while (!queue.isEmpty()) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return strToTurns.get(curr);
                }

                List<String> neighbors = getNeighbors(curr);

                for (String neighbor : neighbors) {
                    if (strToTurns.containsKey(neighbor) || deads.contains(neighbor)) {
                        continue;
                    }

                    strToTurns.put(neighbor, strToTurns.get(curr) + 1);
                    queue.offer(neighbor);
                }
            }

            return -1;
        }

        private List<String> getNeighbors(String curr) {
            List<String> res = new ArrayList<>();
            char[] arr = curr.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];

                arr[i] = ch == '9' ? '0' : (char) (ch + 1);
                res.add(String.valueOf(arr));

                arr[i] = ch == '0' ? '9' : (char) (ch - 1);
                res.add(String.valueOf(arr));

                arr[i] = ch;

            }

            return res;
        }
    }

    static class Solution4 {
        public int openLock(String[] deadends, String target) {
            String start = "0000";

            Set<String> deads = new HashSet<>();
            for (String dead : deadends) {
                deads.add(dead);
            }

            if (deads.contains(start)) {
                return -1;
            }

            Set<String> begin = new HashSet<>();
            Set<String> end = new HashSet<>();

            begin.add(start);
            end.add(target);

            Set<String> visited = new HashSet<>();

            int step = 0;

            while (!begin.isEmpty() && !end.isEmpty()) {
                Set<String> tmp = new HashSet<>();

                for (String curr : begin) {
                    if (end.contains(curr)) {
                        return step;
                    }

                    visited.add(curr);

                    List<String> neighbors = getNeighbors(curr);

                    for (String neighbor : neighbors) {
                        if (deads.contains(neighbor) || visited.contains(neighbor)) {
                            continue;
                        }

                        tmp.add(neighbor);
                    }
                }

                step++;

                begin = end;
                end = tmp;

            }

            return -1;
        }

        private List<String> getNeighbors(String curr) {
            List<String> res = new ArrayList<>();
            char[] arr = curr.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];

                arr[i] = ch == '9' ? '0' : (char) (ch + 1);
                res.add(String.valueOf(arr));

                arr[i] = ch == '0' ? '9' : (char) (ch - 1);
                res.add(String.valueOf(arr));

                arr[i] = ch;

            }

            return res;

        }
    }


}
