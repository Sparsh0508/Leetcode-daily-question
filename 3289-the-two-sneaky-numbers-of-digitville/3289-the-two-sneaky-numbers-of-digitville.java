class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int i =0;i<n;i++){
            freq[nums[i]]++;
        }
        int[] ans = new int[2];
        int j = 0;
        for(int i= 0;i<freq.length;i++){
            if(freq[i] == 2){
                ans[j] = i;
                j++;
                if(j == 2){
                    break;
                }
            }
        }
        return ans;
    }
}