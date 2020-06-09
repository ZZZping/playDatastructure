public class quickSort {

    public void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        //�����ν�������
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        //���Ұ�ν�������
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        //pivot�д�ŵ��������е�Ԫ��
        int pivot = arr[left + (right - left) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left ++;
            }
            while (arr[right] > pivot) {
                right --;
            }
            if (left <= right) {
                swap(arr, left, right);
                left ++;
                right --;
            }
        }
        return left;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
