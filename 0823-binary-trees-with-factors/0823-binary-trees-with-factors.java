class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Long> hm = new HashMap<>();
        for(int root : arr){
            hm.put(root,1L);
            for(int factor : arr){
                if(factor >= root){
                    break;
                }
                if(root % factor == 0 && hm.containsKey(root/factor)){
                    hm.put(root,(hm.get(root) +hm.get(factor) * hm.get(root/factor)));
                }
            }
        }
        long total = 0;
        for(int key : hm.keySet()){
            total = (total + hm.get(key)) % 1_000_000_007;
        }
        return (int) total;
    }
}