public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();
        int[] nums = {1, 3, 5, 6, 7, 4};
        for (int num: nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
    }
}
