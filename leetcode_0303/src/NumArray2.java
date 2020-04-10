public class NumArray2 {
    /**
     * sum[i]存储q前i个元素的和
     * sum[0] = 0;
     * sum[i] 存储nums[0,....,i - 1]的和
     */
    private int[] sum;

    public NumArray2(int[] nums){
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i ++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    public int sumRange(int i, int j){
        //sum[j + 1]的和为前j个元素之和，sum[i]是前i - 1个元素之和，详见得到[i, j]的和
        return sum[j + 1] - sum[i];
    }
}
