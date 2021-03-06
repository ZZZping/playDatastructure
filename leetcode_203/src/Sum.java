public class Sum {
    public static int sum(int[] arr) {
        return sum(arr,0);
    }

    /**
     * @param arr 目标数组
     * @param l 开始左边界
     * @return 递归调用，return arr[l
 + sum(arr, l+1)     */
    private static int sum(int[] arr, int l){
        if (l == arr.length) {
            return 0;
        }
        return arr[l] +sum(arr, l + 1);
        //arr[0] + sum(arr, 1) --> arr[0] + arr[1] + sum(arr, 2) --> ...
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
