public class NumArray {
    private SegnmentTree<Integer> segnmentTree;

    /**
     * ´´½¨segment tree
     * @param nums segment tree
     */
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i ++) {
                data[i] = nums[i];
            }
            segnmentTree = new SegnmentTree<>(data, Integer::sum);
        }
    }

    public int sumRange(int i, int j) {
        if (segnmentTree == null) {
            throw new IllegalArgumentException("Segment tree is null");
        }
        return segnmentTree.query(i, j);
    }
}
