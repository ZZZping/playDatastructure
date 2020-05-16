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
}
