public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 6, 0, 7, 9, 4};
        quickSort quickSort = new quickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
    }
}
