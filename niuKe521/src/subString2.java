import java.util.Scanner;
import java.util.Stack;

/**
 * ��Ŀ����
 * ���һ���ַ�����������ͬ�ַ������Ӷ���,�ͳ�����ַ�����ż��������"xyzxyz"��"aaaaaa"��ż��,����"ababab"��"xyzxy"ȴ���ǡ�
 * ţţ���ڸ���һ��ֻ����Сд��ĸ��ż��s,����Դ��ַ���s��ĩβɾ��1�����߶���ַ�,��֤ɾ��֮����ַ�������һ��ż��,ţţ��֪��ɾ��֮��õ��ż�������Ƕ��١�
 * ��������:
 * �������һ���ַ���s,�ַ�������length(2 �� length �� 200),��֤s��һ��ż������Сд��ĸ����
 * �������:
 * ���һ������,��ʾɾ��֮���ܵõ����ż�������Ƕ��١���֤���������з����
 * ���룺
 *      abaababaab
 * ���
 *      6
 */
public class subString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() == 0) {
            throw new IllegalArgumentException("null");
        }
        //�����ַ�����Ԫ����ͬʱ
        int flag = 0;
        for (int i = 0; i < s.length() - 1; i ++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag = s.length() - 2;
                break;
            }
        }
        //������ַ�����Ԫ�ز�ͬ
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
