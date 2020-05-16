import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        selectionSort selectionSort = new selectionSort();
        insertSort insertSort = new insertSort();
        Random random = new Random();
        int n = 10;
//        Integer[] nums = new Integer[]{2, 3, 5, 1, 6, 0, 7, 9, 4, 8};
        Integer[] nums = new ArrayList<Integer>().toArray(new Integer[10]);
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = random.nextInt(n);
        }
        selectionSort.sort(nums);
        System.out.println("==========");
        insertSort.sort(nums);
    }
}
