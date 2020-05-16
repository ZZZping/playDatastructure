
public class Main2 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {1, 2, 4, 6, 3, 7, 9, 10, 26};
        for (int num : nums) {
            bst.add(num);
        }
        bst.levelOrder();
        System.out.println("==========================");
        bst.inOrder();
    }


}
