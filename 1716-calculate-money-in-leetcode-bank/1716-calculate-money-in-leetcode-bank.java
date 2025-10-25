class Solution {
    public int totalMoney(int n) {
        int count = 0;
        if(n < 8){
            for(int i = 1;i<=n;i++){
                count += i;
            }
            return count;
        }
        int weeks = n/7;
        int remDays = n%7;

        count = 28 * weeks + 7*(weeks * (weeks-1)) /2;

        for(int i = 0;i<remDays;i++){
            count += weeks + 1 + i;
        }

        return count;

    }
}