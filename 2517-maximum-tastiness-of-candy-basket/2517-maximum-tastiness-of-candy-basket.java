class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0;
        int high = price[price.length-1]-price[0];
        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if(canPick(price,mid,k)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static boolean canPick(int[] price,int mid,int k){
        int count = 1;
        int last = price[0];
        for(int i = 0;i<price.length;i++){
            if(price[i]-last >= mid){
                count++;
                last = price[i];
                if(count >= k){
                    return true;
                }
            }
        }
        return false;
    }
}