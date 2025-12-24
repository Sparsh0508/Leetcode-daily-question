class Solution {
    public int countPartitions(int[] nums) {
        int even = nums[0];
        int odd = 0;
        int c = 0;
        for(int i = 1;i<nums.length;i++){
            odd+=nums[i];
        }
        // if((even-odd) %2 ==0){
        //     c++;
        // }
        for(int i = 1;i<nums.length;i++){
            even += nums[i];
            odd -= nums[i];
            if((even-odd)%2==0){
                c++;
            }
        }
        return c;
    }
}