class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            s = help(s);
        }
        return s.charAt(0) == s.charAt(1);
    }
    public static String help(String s){
        String str = "";
        for(int i = 0;i<s.length()-1;i++){
            int a = s.charAt(i) - '0'; 
            int b = s.charAt(i+1) - '0';
            int c = (a + b) % 10;
            str += String.valueOf(c);
        }
        return str;
    }
}