class Solution {
    public int minOperations(int[] nums) {
        int i = 0;

        int c = 0;
        int n = nums.length;
        while(i<n-2){
            if(nums[i] != 1){
                if(nums[i] == 0){
                    nums[i] = 1;
                }else{
                    nums[i] = 0;
                }
                if(nums[i+1] == 0){
                    nums[i+1] = 1;
                }else{
                    nums[i+1] = 0;
                }
                if(nums[i+2] == 0){
                    nums[i+2] = 1;
                }else{
                    nums[i+2] = 0;
                }
                c++;
            }
            i++;
        }
        if(nums[n-1] == 0 || nums[n-2] == 0){
            return -1;
        }
        return c;
    }
}