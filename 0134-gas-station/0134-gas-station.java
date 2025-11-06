class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sum2=0;
        for(int i=0; i<gas.length; i++){
            sum2+=gas[i];
            sum2-=cost[i];
        }
        if(sum2<0) return -1;

        int sum=0;
        int curr=0;
        for(int i=0; i<gas.length; i++){
            sum+=(gas[i]-cost[i]);
            if(sum<0){
                curr=(i+1);
                sum=0;
            }
        }

        return curr;
    }
}