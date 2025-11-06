class Solution {
    public int finalValueAfterOperations(String[] op) {
        int ans = 0;
        for(int i = 0 ;i<op.length;i++){
            if (op[i].charAt(1) == '+'){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
    }
}