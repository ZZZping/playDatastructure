import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0, j = 0; i < s.length(); i = j) {
            while(j < s.length() && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            if(j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }
        }
        return res;
    }
}
