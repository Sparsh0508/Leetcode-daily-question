class Solution {
    public int distributeCandies(int[] candy) {
        int val = candy.length/2;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<candy.length ;i++){
            hs.add(candy[i]);
        }

        return Math.min(hs.size(),val);
    }
}