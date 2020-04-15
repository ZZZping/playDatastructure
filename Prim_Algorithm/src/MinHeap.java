public class MinHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    // ���캯��, ����һ���ն�, ������ capacity ��Ԫ��
    public MinHeap(int capacity) {
        // ע������д������Ҫ new Object�����벻��ͨ��
        data = (Item[]) new Comparable[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    // ͨ����һ�����飬����һ����С��
    public MinHeap(Item[] arr) {
        int n = arr.length;
        this.capacity = n;
        data = (Item[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        this.count = n;
        for (int i = count / 2; i >= 1; i++) {
            shiftDown(i);
        }
    }

    // ���ض��е�Ԫ�ظ���
    public int size() {
        return count;
    }

    // ���ض����Ƿ�Ϊ��
    public boolean isEmpty() {
        return count == 0;
    }

    // ����С���в���һ���µ�Ԫ�� item
    public void insert(Item item) {
        assert count < capacity;
        count++;
        data[count] = item;
        shiftUp(count);
    }

    // ����С����ȡ���Ѷ�Ԫ��, ���������洢����С����
    public Item extractMin() {
        assert count > 0;
        Item min = data[1];
        swap(data, 1, count);
        count--;
        shiftDown(1);
        return min;
    }

    // ��ȡ��С���еĶѶ�Ԫ��
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }


    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(data, k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {// ֻҪ�����ӣ���Ӧ�ÿ����Ƿ���� shiftDown
            int t = 2 * k;
            if (t + 1 < count && data[t].compareTo(data[t + 1]) > 0) {
                t++;
            }
            if (data[t].compareTo(data[k]) > 0) {
                // ������������С���Ǹ�Ԫ�ض��ȸ��״󣬾�������С�ѵ����ʣ�ѭ���˳�
                break;
            }
            swap(data, t, k);
            k = t;
        }
    }

    private void swap(Item[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        Item temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>(10);

        minHeap.insert(9);
        minHeap.insert(8);
        minHeap.insert(7);

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
    }
}