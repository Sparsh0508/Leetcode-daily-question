class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();
        back(nums,al,0);
        return al;
    }
    public static void back(int[] nums, List<List<Integer>> al , int idx){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i : nums){
                temp.add(i);
            }
            al.add(temp);
            return;
        }
        for(int i = idx;i<nums.length;i++){
            swap(nums,idx,i);
            back(nums,al,idx+1);
            swap(nums,idx,i);
        }
    }
    public static void swap(int[] arr,int idx,int i){
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }
}