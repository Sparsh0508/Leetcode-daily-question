class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1];
        for(int i = 0;i<memo.length;i++){
            memo[i] = -1;
        }
        int ans = help(0,nums,memo);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static int help(int idx , int[] nums,int[] memo){
        if(idx == nums.length-1){
            return 0;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }
        int ans = Integer.MAX_VALUE;
        for(int j = idx+1;j<= idx+nums[idx] && j<nums.length;j++){
            int val = help(j,nums,memo);
            if(val != Integer.MAX_VALUE){
                ans = Math.min(ans,val+1);
            }
        }
        return memo[idx] = ans;
    }

}