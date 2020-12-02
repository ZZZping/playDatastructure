import java.util.ArrayList;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = new int[4];
        int flag = 0;
        for (int i = 0; i < 4; i ++) {
            if (A[i] + B[i + 1] + C[i + 2] + D[i + 3] == 0) {
                flag ++;
                arrayList.add(i);
            }
        }
        return flag;
    }
}
