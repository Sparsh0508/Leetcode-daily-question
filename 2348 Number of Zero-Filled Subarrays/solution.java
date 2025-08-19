class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long count = 0;
        long continous = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                continous++;
                count+= continous;
            }else{
                continous = 0;
            }
        }
        return count;
    }
}