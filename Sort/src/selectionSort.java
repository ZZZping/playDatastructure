import com.model.exch;
import com.model.less;
import com.model.show;

public class selectionSort {
    /**
     * ѡ��������ʹ��min�±��ʾ��С�±꣬
     * �������������ҳ���a[min]С��Ԫ�أ�
     * ���ҽ�min��Ϊ����С���±꣬��󽻻�Ԫ��
     * @param a Ŀ������
     */
    public static void sort(Comparable[] a) {
        less less = new less();
        exch exch = new exch();
        show show = new show();
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            int min = i;
            for (int j = i + 1; j < N; j ++) {
                //���a[j]��a[i]С���ͽ���Сֵ���±���Ϊj
                if (less.less(a[j], a[min])) {
                    min = j;
                }
            }
            //����a[i], a[min]���±�
            exch.exch(a, i, min);
        }
        show.show(a);
    }
}
