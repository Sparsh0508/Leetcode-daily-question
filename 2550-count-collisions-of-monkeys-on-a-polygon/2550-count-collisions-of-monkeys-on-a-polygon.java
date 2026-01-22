class Solution {
    public int monkeyMove(int n) {
        long res = 1;
        long base = 2;
        int i = 0;
        while(i<n){
            res = (2*res) % 1_000_000_007;
            i++;
        }
        return (int)((res - 2 + 1_000_000_007) % 1_000_000_007);

    }
}