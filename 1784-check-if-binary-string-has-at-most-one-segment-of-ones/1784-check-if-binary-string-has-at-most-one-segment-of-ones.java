class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length() == 1){
            return true;
        }
        boolean zeroPass = false;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '0'){
                zeroPass = true;
            }else{
                if(zeroPass){
                    return false;
                }
            }
        }
        return true;
    }
}