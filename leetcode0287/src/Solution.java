public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //ÂıÖ¸Õë
        int slow = 0;
        //¿ìÖ¸Õë
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            if (slow == nums[slow]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
