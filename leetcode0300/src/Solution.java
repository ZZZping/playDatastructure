import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            //dp:����������
            //0:�ӵ�0��Ԫ�ؿ�ʼ���������Ԫ��
            //len:����Ԫ�أ����������Ԫ��
            //x:�������鳤��
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
