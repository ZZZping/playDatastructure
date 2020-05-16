import com.model.exch;
import com.model.less;
import com.model.show;

public class selectionSort {
    /**
     * 选择排序，先使用min下标表示最小下标，
     * 从数组中依次找出比a[min]小的元素，
     * 并且将min设为比他小的下标，最后交换元素
     * @param a 目标数组
     */
    public static void sort(Comparable[] a) {
        less less = new less();
        exch exch = new exch();
        show show = new show();
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            int min = i;
            for (int j = i + 1; j < N; j ++) {
                //如果a[j]比a[i]小，就将最小值的下标设为j
                if (less.less(a[j], a[min])) {
                    min = j;
                }
            }
            //交换a[i], a[min]的下标
            exch.exch(a, i, min);
        }
        show.show(a);
    }
}
