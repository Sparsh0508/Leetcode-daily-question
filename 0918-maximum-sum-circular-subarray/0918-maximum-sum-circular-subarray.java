class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];

        for(int num : nums){
            currMax = Math.max(num,currMax + num);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(num,currMin + num);
            minSum = Math.min(minSum,currMin);

            total += num; 
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum,total-minSum);
    }
}