import com.model.exch;
import com.model.less;
import com.model.show;

public class insertSort {
    public static void sort(Comparable[] a) {
        less less = new less();
        exch exch = new exch();
        show show = new show();
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            for (int j = i; j > 0 && less.less(a[j], a[j - 1]); j --) {
                exch.exch(a, j, j - 1);
            }
        }
        show.show(a);
    }

    public void insertSort(Comparable[] A) {
        for (int i = 1; i < A.length; i ++) {
            Comparable key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j].compareTo(key) > 0) {
                A[j + 1] = A[j];
                j --;
            }
            A[j + 1] = key;
        }
        show show = new show();
        show.show(A);
    }


}
