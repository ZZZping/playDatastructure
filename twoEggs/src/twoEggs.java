public class twoEggs {
    public static final int nFloor = 100;
    public static final int nEgg = 2;

    public static final int[][] arr = new int[nFloor][nEgg];

    public static int twoEggs(int nFloors, int nEggs) {

        /*
        ֻ��һ����
         */
        if (nEggs <= 1) {
            return nFloors;
        }
        /*
        ¥����С�ڵ���1
         */
        if (nFloors == 0 || nFloors == 1) {
            return nFloors;
        }
        //������
        int min = nFloors;

        /*
        ����ά������Ϊ��
         */
        if (arr[nFloors - 1][nEggs - 1] != 0) {
            return arr[nFloors - 1][nEggs - 1];
        }

        /*
        ������m¥�㣬n��ӥ�������ڵ�i����̽ʱ���������״̬��һ��״̬��ӥ��ˤ���ˣ���������һ��ֻ��n-1��ӥ����
        ͬʱ��¥����Ҳ����Ϊi-1����һ��״̬��ӥ��û��ˤ�ƣ���ôӥ���������䣬����n����¥����������Ϊm-i�㡣
        ����һ������ͱ��ֽ�Ϊ������ģ��С�������⣬ͨ���ݹ�ķ�ʽ��⣬�ݹ�������3��״̬������
        1�����ӥ��ֻʣ1������ôֻ�ܶ����е�¥�������٣�
        2�����¥����0������Ҫ��̽0�Σ�
        3�����¥����1������Ҫֻ��Ҫ��̽1�Ρ�
        f(m, n) = min{max{f(i - 1, n - 1) + 1, f(m - 1, n) + 1}}
         */
        for (int i = 1; i < nFloors; i ++) {
            /*
            ��һ�������ˣ�ʣ��n - 1������¥��ʣ��i - 1��
             */
            int a = twoEggs(i - 1, nEggs - 1) + 1;
            /*
            ��һ����û�飬¥���Ϊm - i
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
