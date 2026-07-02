class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i = 0;i<piles.length;i++){
            right = Math.max(right,piles[i]);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(canEat(piles,h,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public static boolean canEat(int[] arr,int h,int k){
        int hrs = 0;
        for(int pile : arr){
            hrs += (pile+k-1)/k;
        }
        return hrs <=h;
    }
}