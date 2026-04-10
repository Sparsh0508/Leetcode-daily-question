class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String str = "";
        for(String word : words){
            str += word;
            if(s.startsWith(str)){
                if(s.length() == str.length()){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}