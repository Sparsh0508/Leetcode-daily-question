class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = 101;
        int max = 0;
        for(int num : nums){
            min = Math.min(num,min);
            max = Math.max(max,num);
        }
        int ans = -1;
        for(int num : nums){
            if(num == min || num == max){
                continue;
            }
            ans = num;
            break;
        }
        return ans;
    }
}