public class Main {

    public static void main(String[] args) {
        int[][] array = {{1,1,0},{1,1,0},{0,0,1}};
        Solution0 solution0 = new Solution0();
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findCircleNum(array));
    }
}
