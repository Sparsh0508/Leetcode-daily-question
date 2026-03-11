class Solution {
    Integer[][] dp;
    public int findLength(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        int ans = 0;
        for(int i = 0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                ans = Math.max(ans,help(nums1,nums2,i,j));    
            }
        }
        return ans;
    }
    public int help(int[] nums1, int[] nums2,int idx1,int idx2){
        if(idx1 == nums1.length || idx2 == nums2.length){
            return 0;
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(nums1[idx1] == nums2[idx2]){
            dp[idx1][idx2] = 1 + help(nums1,nums2,idx1+1,idx2+1); 
        }else{
            dp[idx1][idx2] = 0;
        }   
        return dp[idx1][idx2];
    }
}