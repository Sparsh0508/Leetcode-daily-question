class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Double.NEGATIVE_INFINITY;
        int curr = 0;
        int begin = 0;
        for(int end = 0;end<nums.length;end++){
            curr += nums[end];
            if(end -begin + 1 == k){
                double avg = (double)curr/k;
                ans = Math.max(ans,avg);
                curr -= nums[begin];
                begin++;
            }
        }
        return ans;
    }
}