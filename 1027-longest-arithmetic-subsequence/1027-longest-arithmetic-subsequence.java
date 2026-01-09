class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                ans = Math.max(ans,2+help(nums,i,nums[j]-nums[i],dp));
            }
        } 
        return ans;
    }
    public static int help(int[] nums,int idx,int diff,HashMap<Integer,Integer>[] dp){
        if(idx <0){
            return 0;
        }
        if (dp[idx].containsKey(diff)) {
            return dp[idx].get(diff);
        }
        int ans = 0;
        for(int j = idx-1;j>=0;j--){
            if(nums[idx]-nums[j] == diff){
                ans = Math.max(ans,1+help(nums,j,diff,dp));
            }
        }
        dp[idx].put(diff,ans);
        return ans;
    }
}