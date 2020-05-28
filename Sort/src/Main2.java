public class Main2 {
    public static void main(String[] args) {
        mergeSort mergeSort = new mergeSort();
        int[] arr = {2, 3, 5, 1, 6, 0, 7, 9, 4};
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }
        System.out.println("==========");
        mergeSort.mergeSort(arr);
        for (int i = 0; i < args.length; i ++) {
            System.out.println(arr[i] + " ");
        }

    }

}
