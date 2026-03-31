class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0;i<=32;i++){
            int c1 = 0;
            int temp = (1 << i);
            for(int num : nums){
                if((num & temp) != 0){
                    c1++;
                }
            }
            if(c1 % 3 == 1){
                ans = ans|temp;
            }
        }
        return ans;
    }
}