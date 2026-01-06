class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] c : cuboids){
            Arrays.sort(c);
        }

        Arrays.sort(cuboids,(a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2]-b[2];
        });

        int[][] dp = new int[cuboids.length][cuboids.length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return help(cuboids,-1,0,dp);
    }
    int help(int[][] arr,int prev,int curr,int[][] dp){
        if(curr == arr.length){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int skip = help(arr,prev,curr+1,dp);
        int take = 0;
        if(prev == -1 || canStack(arr,prev,curr)){
            take = arr[curr][2] + help(arr,curr,curr+1,dp);
        }
        return dp[curr][prev+1] = Math.max(take,skip);
    }
    boolean canStack(int[][] arr,int bottom,int top){
        return arr[top][0] >= arr[bottom][0] &&
               arr[top][1] >= arr[bottom][1] &&
               arr[top][2] >= arr[bottom][2];
   }
}
