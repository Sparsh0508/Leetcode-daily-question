class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        String str = "";
        if(s.length() < k){
            return false;
        }
        for(int i = 0;i<s.length()-k+1;i++){
            str = s.substring(i,i+k);
            hs.add(str);
            if(hs.size() >= Math.pow(2,k)){
                return true;
            }
        }
        return false;
    }
}