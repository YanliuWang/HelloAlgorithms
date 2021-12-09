import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 412
 * @author yanliu
 * @create 2021-11-21-10:44 AM
 */
public class FizzBuzz {
    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                String val = "";

                if (i % 3 == 0 && i % 5 == 0) {
                    val = "FizzBuzz";

                } else if (i % 3 == 0) {
                    val = "Fizz";

                } else if (i % 5 == 0) {
                    val = "Buzz";

                } else {
                    val = String.valueOf(i);

                }

                res.add(val);

            }

            return res;
        }
    }
}
