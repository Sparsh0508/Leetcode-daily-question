class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        while (n > 0) {
            long rem = n % 10;
            if (rem != 0) {
                ans = ans * 10 + rem; // ✅ fixed order
            }
            n /= 10;
        }
        long res = 0;
        while(ans > 0){
            long rem = ans % 10;
            res = res * 10 + rem;
            ans /= 10;
        }
        return res;
    }
}
