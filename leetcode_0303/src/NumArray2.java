public class NumArray2 {
    /**
     * sum[i]�洢qǰi��Ԫ�صĺ�
     * sum[0] = 0;
     * sum[i] �洢nums[0,....,i - 1]�ĺ�
     */
    private int[] sum;

    public NumArray2(int[] nums){
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i ++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    public int sumRange(int i, int j){
        //sum[j + 1]�ĺ�Ϊǰj��Ԫ��֮�ͣ�sum[i]��ǰi - 1��Ԫ��֮�ͣ�����õ�[i, j]�ĺ�
        return sum[j + 1] - sum[i];
    }
}
