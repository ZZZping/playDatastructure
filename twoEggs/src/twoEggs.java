public class twoEggs {
    public static final int nFloor = 100;
    public static final int nEgg = 2;

    public static final int[][] arr = new int[nFloor][nEgg];

    public static int twoEggs(int nFloors, int nEggs) {

        /*
        只有一个蛋
         */
        if (nEggs <= 1) {
            return nFloors;
        }
        /*
        楼层数小于等于1
         */
        if (nFloors == 0 || nFloors == 1) {
            return nFloors;
        }
        //最差情况
        int min = nFloors;

        /*
        将二维数组设为空
         */
        if (arr[nFloors - 1][nEggs - 1] != 0) {
            return arr[nFloors - 1][nEggs - 1];
        }

        /*
        假设有m楼层，n个鹰蛋，则在第i层试探时会出现两种状态，一种状态是鹰蛋摔破了，则我们下一步只有n-1个鹰蛋，
        同时总楼层数也缩减为i-1，另一种状态是鹰蛋没有摔破，那么鹰蛋总数不变，还是n个，楼层数则缩减为m-i层。
        这样一个问题就被分解为两个规模更小的子问题，通过递归的方式求解，递归在以下3个状态结束：
        1）如果鹰蛋只剩1个，那么只能对所有的楼层进行穷举；
        2）如果楼层是0，则需要试探0次；
        3）如果楼层是1，则需要只需要试探1次。
        f(m, n) = min{max{f(i - 1, n - 1) + 1, f(m - 1, n) + 1}}
         */
        for (int i = 1; i < nFloors; i ++) {
            /*
            第一个蛋碎了，剩下n - 1个蛋，楼层剩下i - 1层
             */
            int a = twoEggs(i - 1, nEggs - 1) + 1;
            /*
            第一个蛋没碎，楼层变为m - i
             */
            int b = twoEggs(nFloors - i, nEggs) + 1;
            int v = Math.max(a, b);

            if (min > v) {
                min = v;
            }
        }

        arr[nFloors - 1][nEggs - 1] = min;
        return min;

    }

    public static int twoEggs1(int nFloors, int nEggs) {
        int[][] dp = new int[nFloors + 1][nEggs + 1];
        int m = 0;
        while (dp[m][nEggs] < nFloors) {
            m ++;
            for (int i = 1; i <= nEggs; i ++) {
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
            }
        }
        return m;
    }

    public static int twoEggs2(int nFloors, int nEggs) {
        int dp[] = new int[nFloors + 1];
        int m = 0;
        for (m = 0; dp[nEggs] < nFloors; m ++) {
            for (int egg = nEggs; egg > 0; egg --) {
                dp[egg] += dp[egg - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int a = twoEggs2(nFloor, nEgg);
        System.out.println(a);
    }

}
