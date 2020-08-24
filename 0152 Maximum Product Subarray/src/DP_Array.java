public class DP_Array {
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }

            // dp[i][0]: 以 nums[i]结尾的连续子数组的最小值
            // dp[i][1]: 以 nums[i]结尾的连续子数组的最大值
            int[][] dp = new int[len][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];

            int res = dp[0][1];

            for (int i = 1; i < len; i++) {
                if (nums[i] >= 0) {
                    dp[i][0] = Math.min (nums[i], dp[i - 1][0] * nums[i]);
                    dp[i][1] = Math.max (nums[i], dp[i - 1][1] * nums[i]);
                } else {
                    dp[i][0] = Math.min (nums[i], nums[i] * dp[i - 1][1]);
                    dp[i][1] = Math.max (nums[i], nums[i] * dp[i - 1][0]);
                }
                res = Math.max (res, dp[i][1]);
            }

            return res;
        }
    }
}
