class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>(),res);
        return res;
    }
    public static void backtrack(int[] nums,boolean[] used,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;

            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums,used,temp,res);
            temp.remove(temp.size() -1);
            used[i] = false;
        }

    }
}