class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[letters.length-1] <= target){
            return letters[0];
        }
        int low = 0;
        int high = letters.length-1;
        int mid = 0;
        int ans = 0;
        while(low<=high){
            mid = low + (high - low)/2;
            if(letters[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return letters[low];
    
}
}