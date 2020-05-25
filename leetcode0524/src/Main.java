import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "abpcplea";
        List<String> list = Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"});
        System.out.println(solution2.findLongestWord(s, list));
    }
}
