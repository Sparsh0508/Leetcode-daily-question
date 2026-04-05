class Solution {
    public int smallestNumber(int n, int t) {
        while(n < 101){
            int prod = solve(n);
            if(prod % t == 0){
                return n;
            }
            n++;
        }
        return -1;
    }
    public static int solve(int n){
        int prod = 1;
        while(n > 0){
            int rem = n % 10;
            prod *= rem;
            n /= 10;
        }
        return prod;
    }
}