/**
 * @author yanliu
 * @create 2022-02-18-5:33 PM
 */
public class PredictTheWinner {
    static class Solution1 {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null || nums.length < 2) {
                return true;
            }

            return winner(nums, 0, nums.length - 1, 1) >= 0;
        }


        // get the total scores that the first choosing player can get more
        // player1 choose the maximum score -> add the score to the total score
        // player2 choose the minimum score -> subtract the score to the total score
        private int winner(int[] nums, int start, int end, int turn) {
            if (start == end) {
                return nums[start];
            }

            int a = turn * nums[start] + winner(nums, start + 1, end, -turn);
            int b = turn * nums[end] + winner(nums, start, end - 1, -turn);

            return turn * Math.max(turn * a, turn * b);
        }
    }

    static class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null || nums.length < 2) {
                return true;
            }

            int N = nums.length;
            int[][] memo = new int[N][N];

            return winner(nums, 0, N - 1, memo) >= 0;
        }

        // more scores that the first choosing player can get
        private int winner(int[] nums, int start, int end, int[][] memo) {
            if (start == end) {
                return nums[start];
            }

            if (memo[start][end] != 0) {
                return memo[start][end];
            }

            int a = nums[start] - winner(nums, start + 1, end, memo);
            int b = nums[end] - winner(nums, start, end - 1, memo);

            memo[start][end] = Math.max(a, b);

            return memo[start][end];
        }
    }

    static class Solution3 {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null || nums.length < 2) {
                return true;
            }

            int N = nums.length;

            int[][] dp = new int[N][N];


            for (int s = N - 1; s >= 0; s--) {
                for (int e = s; e < N; e++) {
                    if (s == e) {
                        dp[s][e] = nums[s];

                    } else {
                        dp[s][e] = Math.max(nums[s] - dp[s + 1][e], nums[e] - dp[s][e - 1]);

                    }
                }
            }

            return dp[0][N - 1] >= 0;
        }
    }
}
