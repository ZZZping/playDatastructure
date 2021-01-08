import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n = s.length();
        for(int j = 0; j < n; j ++) {
            if (j == n - 1 || s.charAt(j) != s.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    res.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }
        return res;
    }
}
