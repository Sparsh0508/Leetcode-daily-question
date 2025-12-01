class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recu(nums,target,0,0);
        // return 
    }
    public static int recu(int[] nums,int target,int idx,int total){
        if(idx == nums.length){
            return total == target ? 1:0;
        }
        return recu(nums,target,idx+1,total + nums[idx]) + recu(nums,target,idx+1,total - nums[idx]);
        
    }
}