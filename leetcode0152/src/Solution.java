/**
 * �˻����������飬��������Ԫ�ؿ�����1~nums.length�������ǹ̶�����
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
