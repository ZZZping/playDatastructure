/*
 * Given four lists A, B, C, D of integer values, compute how many
 * tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where
 * 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the
 * result is guaranteed to be at most 231 - 1.
 *
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    /**
     * A solution with hashmap
     * @param A array A
     * @param B array B
     * @param C array C
     * @param D array D
     * @return the count of array[4] (i, j, k, l) which A[i] + B[j] + C[k] + D[l] = 0
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                int sum = C[i] + D[j];
                //getOrDefault返回指定键所映射的值，如果没有就返回defaultValue
                //指定key---sum，如果map中存在sum对应的值，就返回该值，如果不存在，就返回defaultValue---0
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        /*
         * for (int i = 0; i < n; i ++) {
         *   for (int j = 0; j < n; j ++) {
         *       int sum = A[i] + B[j];
         *       if (map.containsKey(-sum)) {
         *           result += map.get(-sum);
         *       }
         *   }
         * }
         */
        for (int k : A) {
            for (int j = 0; j < n; j++) {
                int sum = k + B[j];
                //当map中包含key：-sum时，返回true
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }

        return result;
    }
}
