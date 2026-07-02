class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = candies[0];
        for(int i = 1;i<candies.length;i++){
            max = Math.max(candies[i],max);
        }   
        int low = 1;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(valid(candies,mid,k)){
                ans = mid;
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static boolean valid(int[] arr,int mid,long k){
        long c= 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] >= mid){
                c += arr[i]/mid;
            }
        }
        return c>=k;
        
    }
}