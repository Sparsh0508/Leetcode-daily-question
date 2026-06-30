class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] idx = {-1,-1,-1};
        for(int i = 0;i<s.length();i++){
            idx[s.charAt(i) - 'a'] =i;
            if(idx[0] != -1 && idx[1] != -1 && idx[2] != -1){
                count += 1 + Math.min(idx[0] , Math.min(idx[1],idx[2]));
            }
        }
        return count;
    }
}