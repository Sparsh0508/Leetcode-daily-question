class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean isFound = true;
        while(isFound){
            isFound = found(nums,original);
            if(isFound){
                original = 2*original;
            }
        }
        return original;
    }
    public static boolean found(int[] nums,int val){
        for(int num : nums){
            if(num == val){
                return true;
            }
        }
        return false;
    }
}