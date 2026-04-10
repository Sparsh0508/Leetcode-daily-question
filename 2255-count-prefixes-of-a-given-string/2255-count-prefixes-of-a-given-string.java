class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for(String word : words){
            if(s.startsWith(word)){
                cnt++;
            }
        }
        return cnt;
    }
}