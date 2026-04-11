class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int res = n;
        for(int k = 0;k<n;k++){
            hm.putIfAbsent(nums[k],new ArrayList<>());
            hm.get(nums[k]).add(k);   
            if(hm.get(nums[k]).size() >= 3){
                ArrayList<Integer> al = hm.get(nums[k]);
                int size = al.size();
                int i = al.get(size-3);
                res = Math.min(res,k-i);
            } 
        }
        return res >= n ? -1 : 2*res;
    }
}