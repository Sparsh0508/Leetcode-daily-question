class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        for(int i = 0;i<s.length();i++){
            int[] freq = new int[26]; 
            for(int j = i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                if(check(freq)){
                    int len = j-i+1;
                    max = Math.max(len,max);
                }
            }
        }
        return max;
    }
    public static boolean check(int[] freq){
        int val = -1;
        for(int i = 0;i<freq.length;i++){
            if(freq[i] == 0){
                continue;
            }
            if(val == -1){
                val = freq[i];
            }
            else if(freq[i] != val){
                return false;
            }
        }
        return true;
    }
}