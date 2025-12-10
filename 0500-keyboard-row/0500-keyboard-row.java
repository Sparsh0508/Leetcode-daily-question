class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> al = new ArrayList<>();
        String first = "qwertyuiop";
        String second =  "asdfghjkl"; 
        String third =  "zxcvbnm"; 
        for(String i : words){
            if(inRow(i,first) || inRow(i,second) || inRow(i,third)){
                al.add(i);
            }
        }
        return al.toArray(new String[0]);
    }
    boolean inRow(String i,String word){
        for(char c : i.toCharArray()){
            if(word.indexOf(Character.toLowerCase(c)) == -1){
                return false;
            }
        }
        return true;
    }
}