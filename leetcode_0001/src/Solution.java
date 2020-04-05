import java.util.HashMap;
import java.util.Map;

public class Solution {
    //with hashmap
    public int[] twoSum(int[] numbers, int target){
        //存储结果
        int[] result = new int[2];
        //JDK1.7后泛型右边的尖括号可以省略类型
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++ i) {
            //contains判断map中是否含有元素
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
