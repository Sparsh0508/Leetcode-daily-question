class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder st = new StringBuilder();
        for(int i = 0;i<str.length;i++){
            for(int j = str[i].length()-1;j>=0;j--){
                st.append(str[i].charAt(j));
            }
            if(i != str.length-1){
                st.append(" ");
            }
        }
        return st.toString();
    }
}