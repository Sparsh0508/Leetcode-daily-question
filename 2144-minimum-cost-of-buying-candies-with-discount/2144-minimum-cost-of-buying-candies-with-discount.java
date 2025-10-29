class Solution {
    public int minimumCost(int[] cost) {
        int sum = 0;
        int n = cost.length;
        if(n <=2){
            for(int i =0;i<n;i++){
                sum += cost[i];
            }
            return sum;
        }
        Arrays.sort(cost);
        int count = 0;
        for(int i = n-1;i>=0;i--){
            if(count == 2){
                count = 0;
                continue;
            }
            sum += cost[i];
            count++;
        }
        return sum;

    }
}