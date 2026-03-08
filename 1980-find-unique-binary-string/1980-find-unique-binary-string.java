class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            if(nums[i].charAt(i) == '1'){
                s.append("0");
            }else{
                s.append("1");
            }
        }
        return s.toString();
    }
}