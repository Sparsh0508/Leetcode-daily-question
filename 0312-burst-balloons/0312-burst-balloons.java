class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        dp = new Integer[arr.length][arr.length];
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }
        return help(arr,0,n+1);
    }
    public int help(int[] nums,int left,int right){
        if(left + 1 == right) return 0;
        if(dp[left][right] != null){
            return dp[left][right];
        }
        int ans =0;
        for(int i = left+1;i<right;i++){
            ans = Math.max(ans,nums[left]*nums[i]*nums[right]  + help(nums,left,i) + help(nums,i,right));
        }
        return dp[left][right] = ans;
    }
}