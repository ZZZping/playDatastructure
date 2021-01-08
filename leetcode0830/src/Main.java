public class Main {

    public static void main(String[] args) {
        String s = "abbbbbbcdddd";
        Solution solution = new Solution();
        System.out.println(solution.largeGroupPositions(s));
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.largeGroupPositions(s));
    }
}
