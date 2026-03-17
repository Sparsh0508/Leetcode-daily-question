class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int i =0;i<nums1.length;i++){
            hm.put(nums1[i][0],nums1[i][1]);
        }
        for(int j = 0;j<nums2.length;j++){
            if(hm.containsKey(nums2[j][0])){
                int val = hm.get(nums2[j][0]);
                hm.put(nums2[j][0],val + nums2[j][1]);
            }else{
                hm.put(nums2[j][0],nums2[j][1]);
            }
        }
        int[][] ans = new int[hm.size()][2];
        int i =0;
        for(int key : hm.keySet()){
            ans[i][0] = key;
            ans[i][1] = hm.get(key);
            i++;
        }
        return ans;
    }
}