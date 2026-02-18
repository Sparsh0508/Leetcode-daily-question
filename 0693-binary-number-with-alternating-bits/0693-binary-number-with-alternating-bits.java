class Solution {
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);

        for(int i = 1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}