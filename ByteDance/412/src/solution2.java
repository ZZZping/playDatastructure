

import java.util.ArrayList;
import java.util.Scanner;

public class solution2 {
    public static void main(String[] args) {
        int a = 0,b = 0, c = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i ++) {
            list.add(sc.nextInt());
        }
        boolean flag = false;
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) > list.get(i + 1)) {
                a = list.get(i);
                flag = true;
                break;
            }
        }
        int count = 0;
        while (flag) {
            for (int i = 1; i < a; i ++) {
                for (int j = 1; j < a; j ++) {
                    if (i + j == a) {
                      list.add(i);
                      list.add(j);
                      count ++;
                      break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
