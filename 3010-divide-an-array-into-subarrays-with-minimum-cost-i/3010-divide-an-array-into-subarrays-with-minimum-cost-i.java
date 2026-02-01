class Solution {
    public int minimumCost(int[] nums) {
        int num1 = nums[0];
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MAX_VALUE;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] < num2){
                num3 = num2;
                num2 = nums[i];
            }
            else if(nums[i] < num3){
                num3 = nums[i];
            }
        } 
        return num1 + num2 + num3;
    }
}