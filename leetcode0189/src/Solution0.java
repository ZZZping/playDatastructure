public class Solution0 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr1 = new int[n];
        while (k > n) {
            for (int i = 0; i < n;i ++) {
                int temp = nums[n - i];
                nums[n - i] = nums[i];
                nums[i] = temp;
            }
            k = k - n;
        }
        for (int i = 0; i < k; i ++ ) {
            arr1[i] = nums[n - k + i];
            for (int j = i + 1; j < n; j ++) {
                arr1[j] = nums[j - i - 1];
            }
        }
        if (k == 0) {
            for(int i = 0; i < n; i++) {
                nums[i] = arr1[i];
            }
        }

    }
}
