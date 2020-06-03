public class Main {

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 4;
        dynamicProgramming1 dynamicProgramming1 = new dynamicProgramming1();
        int q = dynamicProgramming1.momoizedCutRod(p, n);
        System.out.println(q);
    }
}
