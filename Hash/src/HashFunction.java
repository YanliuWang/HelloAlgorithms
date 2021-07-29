/**
 * LintCode 128
 * @author yanliu
 * @create 2021-07-29-21:45
 */
public class HashFunction {
    static class Solution {
        /**
         * @param key: A string you should hash
         * @param HASH_SIZE: An integer
         * @return: An integer
         */
        public int hashCode(char[] key, int HASH_SIZE) {
            // write your code here
            // 固定且无规律的，同一个 key 对应同一个 hashCode
            // magic number 是经验值，找一个冲突小的数
            long ans = 0;

            for (int i = 0; i < key.length; i++) {
                ans = (ans * 33 + (int) key[i]) % HASH_SIZE;
            }

            return (int) ans;
        }
    }
}
