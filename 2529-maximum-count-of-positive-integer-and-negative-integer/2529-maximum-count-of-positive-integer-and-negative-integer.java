class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < 0){
                c++;
            }else if(nums[i] == 0){
                n--;
            }else{
                break;
            }

        }
        return Math.max(c,n-c);  
    }
}