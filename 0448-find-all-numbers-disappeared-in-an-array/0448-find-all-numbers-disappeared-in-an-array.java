class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] freq = new int[nums.length+1];  
        List<Integer> al = new ArrayList<>();     
        for(int i = 0;i<nums.length;i++){
            freq[nums[i]]++;
        }

        for(int i = 1;i<freq.length;i++){
            if(freq[i] == 0){
                al.add(i);
            }
        }
        return al;
    }

}