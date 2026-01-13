class Solution {
    public int strStr(String s1, String s2) {
        if(s2.length() > s1.length()){
            return -1;
        }
        int m = s1.length();
        int n = s2.length();
        for(int i = 0;i<=m-n;i++){
            String str = s1.substring(i,i+n);
            if(str.equals(s2)){
                return i;
            }
        }
        return -1;
    }

}