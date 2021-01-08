public class Solution0 {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        for (int i = 0; i < isConnected.length; i ++) {
            for (int j = i + 1; j < isConnected.length; j ++) {
                if (isConnected[i][j] == 1) {
                   res += 1;
                }
            }
        }
        return res;
    }
}
