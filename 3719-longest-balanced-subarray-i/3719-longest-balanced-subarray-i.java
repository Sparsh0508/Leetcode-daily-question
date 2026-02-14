class Solution {
    public int longestBalanced(int[] nums) {
        HashSet<Integer> even = new HashSet<>();
        HashSet<Integer> odd = new HashSet<>();
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(nums[j] % 2 == 0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                int len = 0;
                if(even.size() == odd.size()){
                    len = j-i+1;
                }
                ans = Math.max(ans,len);
            }
            even.clear();
            odd.clear();
        }
        return ans;
    }
}