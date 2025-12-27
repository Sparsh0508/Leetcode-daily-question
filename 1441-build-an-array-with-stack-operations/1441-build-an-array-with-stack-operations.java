class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> al = new ArrayList<>();
        int idx = 0;
        for(int i = 1;i<=n && idx < target.length;i++){
            if(i==target[idx]){
                al.add("Push");
                idx++;
            }
            else{
                al.add("Push");
                al.add("Pop");
            }
        }
        return al;
    }
}