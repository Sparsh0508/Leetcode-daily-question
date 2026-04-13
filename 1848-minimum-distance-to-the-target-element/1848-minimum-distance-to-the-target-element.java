class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                int k=(Math.abs(i-start));
                if(min>k){
                    min=k;
                }
            }
        }
        return min;
    }
}