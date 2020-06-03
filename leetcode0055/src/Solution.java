public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        int flag = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i <= flag) {
                flag = Math.max(nums[i] + i, flag);
                if (flag > nums[i] - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > flag) {
                return false;
            }
            //ʹ��db
            flag = Math.max(flag, i + nums[i]);
        }
        return true;
    }

}
