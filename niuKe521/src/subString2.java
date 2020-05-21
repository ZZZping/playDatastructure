import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 * 牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1个或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成
 * 输出描述:
 * 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解
 * 输入：
 *      abaababaab
 * 输出
 *      6
 */
public class subString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() == 0) {
            throw new IllegalArgumentException("null");
        }
        //输入字符串中元素相同时
        int flag = 0;
        for (int i = 0; i < s.length() - 1; i ++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag = s.length() - 2;
                break;
            }
        }
        //输入的字符串中元素不同
        System.out.println(flag);
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            stack.push(s.charAt(i));
        }
        for (Character e : stack) {
            stack1.push(stack.peek());
        }
    }
}
