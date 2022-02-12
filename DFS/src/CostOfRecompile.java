import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-19-5:01 PM
 */
public class CostOfRecompile {
    static class Result {
        /*
         * Complete the 'applicationBuildCost' function below.
         *
         * The function is expected to return a STRING_ARRAY.
         * The function accepts STRING_ARRAY lines as parameter.
         */

        static Map<String, List<String>> graph = new HashMap<>();
        static Map<String, Set<String>> depend = new TreeMap<>();

        public static List<String> applicationBuildCost(List<String> lines) {
            // Write your code here
            List<String> res = new ArrayList<>();

            if (lines == null || lines.size() == 0) {
                return res;
            }

            // build graph
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i).split(",");
                String curr = line[0];

                if (!graph.containsKey(curr)) {
                    graph.put(curr, new ArrayList<>());
                }


                for (int j = 1; j < line.length; j++) {
                    List<String> list = graph.getOrDefault(line[j], new ArrayList<>());
                    list.add(curr);

                    graph.put(line[j], list);
                }
            }

            // dfs
            for (String key : graph.keySet()) {
                dfs(key);
            }

            // process for final result
            for (String key : depend.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(key).append(",").append(depend.get(key).size());
                res.add(sb.toString());
            }

            return res;
        }

        private static Set<String> dfs(String key) {
            if (depend.containsKey(key)) {
                return depend.get(key);
            }

            Set<String> res = new HashSet<>();
            for (String node : graph.get(key)) {
                res.addAll(dfs(node));
            }

            res.add(key);
            depend.put(key, res);
            return res;
        }
    }
}
