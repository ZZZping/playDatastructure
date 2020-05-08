/**
 * 统计连续且相同字符串个数并输出
 */

public class yunTu1 {
    public static void main(String[] args) {
        System.out.println(char_count("aaabbbccdde"));

    }

    static String char_count(String arr) {
        if (arr == null || arr.equals("")) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char element = arr.charAt(0);
        int count = 1;
        for (int i = 1; i < arr.length(); i ++) {
            if (element == arr.charAt(i)) {
                count ++;
            } else {
                sb.append(element);
                sb.append(count == 1 ? "" : count);
                element = arr.charAt(i);
                count = 1;
            }
        }
        sb.append(element);
        sb.append(count == 1 ? "" :count);
        return sb.toString();
    }
}
