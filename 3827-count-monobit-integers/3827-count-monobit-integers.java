class Solution {
    public int countMonobit(int n) {
        int c = 0;
        for(int i = 1 ; i<= n;i++){
            if((i & (i+1)) == 0){
                c++;
            }
        }
        return c + 1;
    }
}