class Solution {
    public int numTeams(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                if(nums[i] < nums[j]){
                    for(int k = j+1;k<n;k++){
                        if(nums[j] < nums[k]){
                            c++;
                        }
                    }
                }
            }
        }
        for(int i = 0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                if(nums[i] > nums[j]){
                    for(int k = j+1;k<n;k++){
                        if(nums[j] > nums[k]){
                            c++;
                        }
                    }
                }
            }
        }
        return c;
    }
}