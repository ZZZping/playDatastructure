public class quickSort {

    public void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        //对左半段进行排序
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        //对右半段进行排序
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        //pivot中存放的是数组中的元素
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
