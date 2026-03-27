class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
      HashSet<Integer> hs = new HashSet<>();
      for(int i = 0;i<nums.size();i++){
        int st = nums.get(i).get(0);
        int ed = nums.get(i).get(1);
        for(int j = st;j<=ed;j++){
            hs.add(j);
        }
      }   
      return hs.size();
    }
}