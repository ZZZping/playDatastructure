public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 0;
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == 32) {
                flag ++;
                stringBuffer = str.replace(i, i + 1, "%20");
            }
        }
        if (flag != 0) {
            String string = String.valueOf(stringBuffer);
            return string;
        } else {
            return String.valueOf(str);
        }
    }
}
