class Solution {
    public boolean detectCapitalUse(String word) {
        int c = 0;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                c++;
            }
        }
        if(c==1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }
        if(c == 0 || c == word.length()){
            return true;
        }
        return false;
    }
}