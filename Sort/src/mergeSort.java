public class mergeSort {

    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }


    /**
     * ������array�е�Ԫ�ظ��Ƶ�����helper�У�
     * ͬʱ��¼���������������ʼλ��
     * @param array ��ʼ����
     * @param helper ��������
     * @param low ������λԪ��
     * @param middle ������λԪ��
     * @param high ����ĩλԪ��
     */
    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /*
        ������array���������븴�Ƶ�����helper��
         */
        for (int i = low; i <= high; i ++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*
        ������������helper���Ƚ�helper��������Ԫ�أ�
        ��helper�����н�С��Ԫ�طŵ�����array��
         */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft ++;
            } else {
                array[current] = helper[helperRight];
                helperRight ++;
            }
            current ++;
        }

        /*
        ��helper������벿��ʣ��Ԫ�ظ��Ƶ�array������
         */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i ++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 1, 6, 0, 7, 9, 4};
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        mergeSort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }

    }

}



