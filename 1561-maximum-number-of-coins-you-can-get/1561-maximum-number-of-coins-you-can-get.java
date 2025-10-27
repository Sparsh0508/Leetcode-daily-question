class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int i = 0;
        int j = piles.length-2;
        while(i<piles.length/3){
            count += piles[j];
            i++;
            j = j-2;
        }
        return count;
    }
}