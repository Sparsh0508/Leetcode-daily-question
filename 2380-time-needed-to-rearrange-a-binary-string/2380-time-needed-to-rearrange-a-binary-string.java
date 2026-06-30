class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int c = 0;
        int zeros = 0;
        int time = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0'){
                zeros++;
            }
            else{
                if(zeros >0 ){
                    time = Math.max(time+1,zeros);
                }
            }
        }
        return time;
    }
}