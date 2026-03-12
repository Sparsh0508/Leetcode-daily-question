class Solution {
    Integer[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length]; 
        return help(nums1,nums2,0,0);   
    }
    public int help(int[] nums1,int[] nums2,int i,int j){
        if(nums1.length == i || nums2.length == j){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int take = (nums1[i]*nums2[j]) + Math.max(0,help(nums1,nums2,i+1,j+1));

        int skip1 = help(nums1,nums2,i+1,j);
        int skip2 = help(nums1,nums2,i,j+1);
        return dp[i][j] =  Math.max(take,Math.max(skip1,skip2));

    }
}