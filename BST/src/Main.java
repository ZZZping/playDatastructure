import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();
        Random random = new Random();
//        int[] nums = {1, 3, 5, 6, 7, 4};
//        for (int num: nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
        int n = 1000;
        for (int i = 0; i < 1000; i ++) {
            bst.add(random.nextInt(1000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i ++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("ERROR");
            }
        }
        System.out.println("removeMin test complete");
    }
}
