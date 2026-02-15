class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = Integer.MIN_VALUE;
        int st = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
                if(check(s,i,j)){
                    if(j -i+1 > max){
                        max = j-i+1;
                        st = i;
                    }
                }
            }
        }
        return s.substring(st,st +max);
    }
    public boolean check(String s,int i,int j){
        if(i >=j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return check(s,i+1,j-1);
        }
        return false;
    }
}