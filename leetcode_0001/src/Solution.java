import java.util.HashMap;
import java.util.Map;

public class Solution {
    //with hashmap
    public int[] twoSum(int[] numbers, int target){
        //�洢���
        int[] result = new int[2];
        //JDK1.7�����ұߵļ����ſ���ʡ������
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++ i) {
            //contains�ж�map���Ƿ���Ԫ��
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
