class Solution {
    public boolean judgeCircle(String moves) {
        int cu = 0;
        int cl = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'U'){
                cu++;
            }else if(ch == 'D'){
                cu--;
            }
            if(ch == 'L'){
                cl++;
            }else if(ch == 'R'){
                cl--;
            }
        }
        return (cu == 0 && cl == 0);
    }
}