class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if(s1.charAt(0) != s2.charAt(0) || s2.charAt(0) != s3.charAt(0)){
            return -1;
        }
        int c = 0;
        int i = 0;
        while(i < s1.length() && i < s2.length() && i < s3.length()){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            char ch3 = s3.charAt(i);
            if(ch1 == ch2 && ch2 == ch3){
                c++;
            }else{
                break;
            }
            i++;
        }
        int ans = 0;
        ans += s1.length()-c;
        ans += s2.length()-c;
        ans += s3.length()-c;

        return ans;
    }
}