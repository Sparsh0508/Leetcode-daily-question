class Solution {
    public long maxProduct(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long prod = 1L*nums[nums.length-2]*nums[nums.length-1];
        long ans  = 1L * prod * 100000;
        return ans;
    }
}