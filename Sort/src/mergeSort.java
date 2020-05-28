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
     * 将数组array中的元素复制到数组helper中，
     * 同时记录数组左右两半的起始位置
     * @param array 初始数组
     * @param helper 辅助数组
     * @param low 数组首位元素
     * @param middle 数组中位元素
     * @param high 数组末位元素
     */
    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /*
        将数组array的左右两半复制到数组helper中
         */
        for (int i = low; i <= high; i ++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*
        迭代访问数组helper，比较helper左右两边元素，
        将helper数组中叫小的元素放到数组array中
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
        将helper数组左半部分剩余元素复制到array数组中
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



