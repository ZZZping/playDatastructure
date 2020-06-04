import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            //dp:带搜索数组
            //0:从第0个元素开始，包括这个元素
            //len:结束元素，不包括这个元素
            //x:搜索数组长度
            int i = Arrays.binarySearch(dp, 0 ,len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len ++;
            }
        }
        return len;
    }
}
