class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int i = 0;i<weights.length;i++){
            left = Math.max(left,weights[i]);
            right += weights[i];
        }
        while(left < right){
            int mid = left+(right-left)/2;
            if(canShip(weights,days,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public static boolean canShip(int[] arr,int d,int cap){
        int days = 1;
        int curr = 0;
        for(int w : arr){
            if(curr + w > cap){
                days++;
                curr = 0;
            }
            curr += w;
            
        }
        return days <= d;
    }
}