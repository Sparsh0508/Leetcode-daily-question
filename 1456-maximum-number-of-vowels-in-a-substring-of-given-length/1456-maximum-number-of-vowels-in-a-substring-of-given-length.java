class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int curr = 0;
        int begin = 0;
        for(int end = 0;end<s.length();end++){
            if(isVowel(s.charAt(end))){
                curr++;
            }
            
            if(end-begin+1 >k){
                if(isVowel(s.charAt(begin))){
                    curr--;
                }
                begin++;
            }
            if(end-begin+1 == k){
                ans = Math.max(ans,curr);
            }
        }
        return ans;
    }
    public static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}