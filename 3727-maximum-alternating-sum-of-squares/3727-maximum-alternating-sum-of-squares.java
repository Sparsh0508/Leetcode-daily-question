class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squared = new long[n];
        for(int i = 0;i<n;i++){
            squared[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(squared);
        int a = n/2 ;
        long add = 0;
        long sub = 0;
        for(int i = 0;i<a;i++){  
            sub += squared[i];
        }

        for(int i = a;i<n;i++){
            add += squared[i];
        }
        return add - sub;
    }
}