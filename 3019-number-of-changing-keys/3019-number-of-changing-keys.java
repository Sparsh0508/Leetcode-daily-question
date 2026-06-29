class Solution {
    public int countKeyChanges(String s) {
        int c = 0;
        for(int i = 1;i<s.length();i++){
            char prev = Character.toLowerCase(s.charAt(i-1));
            char ch = Character.toLowerCase(s.charAt(i));
            if(prev != ch){
                c++;
            }
        }
        return c;
    }
}