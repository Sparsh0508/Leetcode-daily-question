class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
        long ans = 0;
        int dec = 0;  

        for(int i = hap.length - 1; i >= 0 && k > 0; i--) {
            int val = hap[i] - dec;
            if(val <= 0) break;  

            ans += val;
            dec++;
            k--;
        }
        return ans;
    }
}
