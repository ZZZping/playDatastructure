import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {
    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();
    public void insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }
    public char firstAppearingOnce() {
        char c = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }
}
