/**
 * 乘机最大的子数组，子数组中元素可以是1~nums.length个，不是固定两个
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxSofa = nums[0];
        int maxHere, minHere;
        for (int i = 1; i < nums.length; i ++) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            maxSofa = Math.max(maxHere, maxSofa);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSofa;
    }
}
