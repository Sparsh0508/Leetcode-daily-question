class Solution {
    public boolean canConstruct(String rn, String mag) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : rn.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch : mag.toCharArray()){
            freq2[ch-'a']++;
        }
        for(int i = 0;i<freq1.length;i++){
            if(freq1[i] > freq2[i]){
                return false;
            }
        }
        return true;
    }
}