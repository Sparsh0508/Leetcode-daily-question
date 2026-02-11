class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return 1+help(1,1,n);
    }
    public int help(int curr,int copy,int n){
        if(n == curr){
            return 0;
        }
        if(curr > n){
            return Integer.MAX_VALUE/2;
       }    
       int copyPaste = 2 + help(curr*2,curr,n);
       int paste = 1 + help(curr + copy,copy,n);
       return  Math.min(copyPaste,paste);
    }
}