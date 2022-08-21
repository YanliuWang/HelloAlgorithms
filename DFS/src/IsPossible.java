/**
 * Expedia OA
 * @author yanliu
 * @create 2022-08-20-9:08 PM
 */
public class IsPossible {
    public boolean isPossible(int a, int b, int c, int d) {
        if (a > c || b > d) {
            return false;
        }

        if (a == c && b == d) {
            return true;
        }

        return isPossible(a, b + a, c, d)
                || isPossible(a + b, b, c, d);
    }
}
