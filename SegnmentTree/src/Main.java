public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegnmentTree<Integer> segnmentTree = new SegnmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segnmentTree);
        //-2 + 0 + 3 = 1
        System.out.println(segnmentTree.query(0, 2));
    }
}
