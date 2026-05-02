class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i = 0;i<=n;i++){
            if(isGood(i)){
                ans++;
            }
        }
        return ans;
    }
    public static boolean isGood(int n){
        boolean change = false;
        while(n > 0){
            int rem = n %10;
            if(rem == 3 || rem == 4 || rem == 7){
                return false;
            }
            if(rem == 2 || rem == 5 || rem == 6 || rem == 9){
                change = true;
            }
            n/=10;
        }
        return change;
    }
}