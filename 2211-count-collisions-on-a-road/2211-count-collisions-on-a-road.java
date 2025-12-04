class Solution {
    public int countCollisions(String s) {
        int n=s.length();

        if (n==1){
            return 0;
        } 
        int l=0, r=n-1;

        while (l<r && s.charAt(l)=='L'){
            l++;
        } 
        while (l<r && s.charAt(r)=='R'){
            r--;
        } 
        if (l>=r){
            return 0;
        }
        int col=0;
        for( ; l<=r; l++){
           col+=(s.charAt(l)!='S'?1:0);
        }
        return col;  
    }
}