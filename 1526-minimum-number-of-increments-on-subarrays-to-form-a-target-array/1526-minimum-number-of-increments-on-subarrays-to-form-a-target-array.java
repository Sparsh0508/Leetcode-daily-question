class Solution {
    public int minNumberOperations(int[] target) {
        int res = target[0];

        for(int i = 1;i<target.length;i++){
            res += Math.max(target[i]-target[i-1],0);

        }
        return res;
    }
}