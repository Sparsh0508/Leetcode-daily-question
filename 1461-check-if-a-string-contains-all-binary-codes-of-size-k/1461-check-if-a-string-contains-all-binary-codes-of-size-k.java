class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        String str = "";
        for(int i = 0;i<s.length()-k+1;i++){
            for(int j = i;j<i+k;j++){
                str += s.charAt(j); 
            }
            hs.add(str);
            str = "";
        }
        if(hs.size() >= Math.pow(2,k)){
            return true;
        }
        return false;
    }
}