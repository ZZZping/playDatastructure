public class Solution2 {
    public void rotate(int[] nums, int k) {
        if(k==0)
            return;
        int j=0;
        while(j<k){
            int temp=0;
            for(int i=0;i<nums.length;i++){
                if(i==0){
                    temp=nums[i];
                    nums[i]=nums[nums.length-1];
                }else{
                    int temp1=nums[i];
                    nums[i]=temp;
                    temp=temp1;
                }
            }
            j++;
        }
    }
}
