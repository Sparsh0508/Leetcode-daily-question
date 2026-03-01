class Solution {
    public String trimTrailingVowels(String s) {
        int j = s.length()-1;
        while(j >= 0){
            if(!(isVowel(s.charAt(j)))){
                break;
            }
            j--;
        }

        return s.substring(0,j+1);
    }
    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}