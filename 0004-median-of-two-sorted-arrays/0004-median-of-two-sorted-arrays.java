class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int k = 0;
        for(int i = 0;i<nums1.length;i++){
            arr[k] = nums1[i];
            k++;
        }
        for(int j = 0;j<nums2.length;j++){
            arr[k] = nums2[j];
            k++;
        }
        Arrays.sort(arr);
        if(arr.length % 2 != 0){
            return arr[arr.length/2];
        }else{
            return (double)(arr[arr.length/2-1] + arr[arr.length/2])/2;
        }
    }
}