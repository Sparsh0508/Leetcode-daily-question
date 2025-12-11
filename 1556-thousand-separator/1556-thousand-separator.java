class Solution {
    public String thousandSeparator(int n) {
        String s = Integer.toString(n);
        int c = 0;
        for(int i  = s.length()-1;i>=0;i--){
            if(c == 3){
                s = s.substring(0,i+1) +"."+s.substring(i+1);
                c=1;
            }else{
                c++;
            }
        }
        return s;
    }
}