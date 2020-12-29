/*
给你一个数组equations，装着若干字符串表示的算式。每个算式equations[i]长度都是 4，而且只有这两种情况：a==b或者a!=b，其中a,b可以是任意小写字母。
你写一个算法，如果equations中所有算式都不会互相冲突，返回 true，否则返回 false。

比如说，输入["a==b","b!=c","c==a"]，算法返回 false，因为这三个算式不可能同时正确。

再比如，输入["c==c","b==d","x!=z"]，算法返回 true，因为这三个算式并不会造成逻辑冲突。
 */

/**
 * @author yanliu
 * @create 2020-12-29-19:56
 */
public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);

                // connect the chars in '==' equation
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);

                // if true, the logic of the equation is false
                if (uf.isConnected(x- 'a', y - 'a')) {
                    return false;
                }

            }
        }

        return true;
    }
}
