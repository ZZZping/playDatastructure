public class NumArray2 {

    private SegnmentTree<Integer> segnmentTree;

    public NumArray2(int[] nums){
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i ++) {
                data[i] = nums[i];
            }
            segnmentTree = new SegnmentTree<>(data,Integer::sum);
        }
    }

    public void update(int i, int val){
        if (segnmentTree == null) {
            throw new IllegalArgumentException("segment Tree is null");
        }
        segnmentTree.set(i, val);
    }

    public int sumRange(int i, int j){
        if (segnmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segnmentTree.query(i, j);
    }

}
