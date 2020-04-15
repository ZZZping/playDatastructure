// ��С�����ѣ�����С�ѵĴ����޸Ķ�����
public class IndexMinHeap<Item extends Comparable> {
    private Item[] data; // ��С�����ѵ�����
    private int[] indexes; // ��С�������е�������data[indexes[0]] ,data[indexes[1]],..., ������С��
    private int[] reverse; // ��С�������еķ����������
    private int count;
    private int capacity;

    public IndexMinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];

        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        // indexes ����� reverse ����������Ϊ 0 ��λ�ö����������
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        this.capacity = capacity;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // ����С�������в���һ���µ�Ԫ��, ��Ԫ�ص�����Ϊ i , Ԫ��Ϊ item
    // ����� i ���ⲿ�����߶��Եģ��Ǵ� 0 ��ʼ��
    public void insert(int i, Item item) {
        assert count < capacity;
        assert i >= 0 && i < capacity;

        // �ڲ���һ���µ�Ԫ��ǰ��Ҫ��֤���� i ���λ����û��Ԫ��
        assert !contain(i);
        i += 1;
        data[i] = item;

        indexes[count + 1] = i; // �ж� indexes ��ֵ�ĵط�����һ��Ҫͬ���� reverse ��ֵ
        reverse[i] = count + 1;

        count++;
        shiftUp(count);
    }

    // ������ i ���ڵ�λ���Ƿ����Ԫ��
    public boolean contain(int i) {
        assert i >= 0 && i < capacity;
        // ��Ϊ 0 ��ʾ�ⲿ���������е� i λ�ò�����Ԫ��
        return reverse[i + 1] != 0;
    }

    // ��ȡ��С������������Ϊi��Ԫ��
    public Item getItem(int i) {
        assert contain(i);
        return data[i + 1];
    }


    // ����С����ȡ���Ѷ�Ԫ��, ���������洢����С����
    public Item extractMin() {
        assert count > 0;
        Item min = data[indexes[1]];
        swapIndexes(1, count);
        count--;
        shiftDown(1);
        return min;
    }

    // ����С��������ȡ���Ѷ�Ԫ�ص�����
    public int extractMinIndex(){
        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndexes( 1 , count );
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);
        return ret;
    }

    // ��ȡ��С���еĶѶ�Ԫ��
    public Item getMin() {
        assert (count > 0);
        return data[indexes[1]];
    }

    public int getMinIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    public void change(int i, Item newItem) {
        assert contain(i);
        i += 1;
        data[i] = newItem;
        // ���� reverse �������������� ֮��,
        // ���ǿ��Էǳ��򵥵�ͨ�� reverse ֱ�Ӷ�λ���� i �� indexes �е�λ��
        // ���ǿ��Էǳ��򵥵�ͨ�� reverse ֱ�Ӷ�λ���� i �� indexes �е�λ��
        // ���ǿ��Էǳ��򵥵�ͨ�� reverse ֱ�Ӷ�λ���� i �� indexes �е�λ��
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    // �����������е����� i �� j
    // �������˷������� reverse ���飬
    // indexes ���鷢���ı��Ժ� ��Ӧ�ľ���Ҫά�� reverse ����
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) > 0) {
            swapIndexes(k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {// ֻҪ�����ӣ���Ӧ�ÿ����Ƿ���� shiftDown
            int t = 2 * k;
            if (t + 1 < count && data[indexes[t]].compareTo(data[indexes[t + 1]]) > 0) {
                t++;
            }
            if (data[indexes[t]].compareTo(data[indexes[k]]) > 0) {
                // ������������С���Ǹ�Ԫ�ض��ȸ��״󣬾�������С�ѵ����ʣ�ѭ���˳�
                break;
            }
            swapIndexes(t, k);
            k = t;
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<Integer>(N);
        for (int i = 0; i < N; i++) {
            indexMinHeap.insert(i, (int) (Math.random() * N));
        }
    }
}