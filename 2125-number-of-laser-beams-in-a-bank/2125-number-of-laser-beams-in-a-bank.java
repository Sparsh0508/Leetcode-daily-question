class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank[0].length();
        int count = 0;
        int prevCount = 0;
        for(int i = 0;i<bank.length;i++){
            int currCount = 0;
            for(int j = 0;j<n;j++){
                if(bank[i].charAt(j) == '1'){
                    currCount++;
                }
            }
            if(currCount == 0){
                continue;
            }
            count += currCount * prevCount;
            prevCount = currCount;
        }
        return count;
    }
}