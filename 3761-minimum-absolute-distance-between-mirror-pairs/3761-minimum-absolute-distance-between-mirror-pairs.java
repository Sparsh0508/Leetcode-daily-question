class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int rev = reverse(nums[i]);
            if(hm.containsKey(nums[i])){
                ans = Math.min(ans,Math.abs(i-hm.get(nums[i])));
            }
            hm.put(rev,i);
        }
         return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int reverse(int num){
        int ans = 0;
        while(num > 0){
            int rem = num %10;
            ans = ans*10+rem;
            num /=10;
        }
        return ans;
    }
}