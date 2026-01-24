class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = -1;
        long sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(prev == nums[i]){
                continue;
            }
            if(nums[i] > k){
                break;
            }
            k++;
            sum += nums[i];
            prev = nums[i];
        }
        return (long)(k + 1) * k /2 - sum;
    }
}