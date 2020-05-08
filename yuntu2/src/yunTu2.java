import java.util.Scanner;

public class yunTu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i ++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }
        res = arraySort(_arr);
        for (int _res_i = 0; _res_i < _arr_size; _res_i ++) {
            System.out.println(res[_res_i]);
        }
    }

    static int[] arraySort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
