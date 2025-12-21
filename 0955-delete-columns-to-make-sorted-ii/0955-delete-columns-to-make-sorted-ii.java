class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sorted = new boolean[n-1];
        int deleted = 0;

        for(int i= 0;i<m;i++){
            boolean bad = false;
            for(int j=0;j < n-1;j++){
                if(!sorted[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                    bad = true;
                    break;
                }
            }
            if(bad){
                deleted++;
                continue;
            }
            for(int j = 0;j<n-1;j++){
                if(!sorted[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
                    sorted[j] = true;
                }
            }
        }
        return deleted;
    }
}