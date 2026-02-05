class Solution {
    public long mod = 1_000_000_007;
    public int monkeyMove(int n) {
        long res = help(2,n);
        return (int)((res - 2 + mod) % mod);
    }
    public long help(int base,int exp){
        if(exp == 0){
            return 1;
        }

        long half = help(2,exp/2);
        long res = (half*half) % mod;

        if ((exp & 1) == 1) {
            res = (res * base) % mod;
        }
        return res;
    }
}