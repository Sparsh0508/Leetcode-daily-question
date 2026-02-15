class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1, j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry==1){
            int d1=0,d2=0;
            if(i>=0){
                d1 =a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                d2=b.charAt(j)-'0';
                j--;
            }
            int sum=d1+d2+carry;
            if(sum==3) sb.append("1"); 
            else if(sum==2){ sb.append("0"); carry=1; }
            else{ sb.append(sum); carry=0; }
        }
        return sb.reverse().toString();
    }
}