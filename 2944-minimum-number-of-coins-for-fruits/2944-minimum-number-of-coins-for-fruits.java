class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length-1;
        for(int i = n/2;i>0;i--){
            int val = prices[2*i];
            for(int j = i;j<2*i;j++){
                val = Math.min(val,prices[j]);
            } 
            prices[i-1] += val;
        }
        return prices[0];
    }
}