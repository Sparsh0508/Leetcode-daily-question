class Solution {
    public int distributeCandies(int[] candy) {
        int val = candy.length/2;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : candy){
            hs.add(num);
        }
        return Math.min(hs.size(),val);
    }
}