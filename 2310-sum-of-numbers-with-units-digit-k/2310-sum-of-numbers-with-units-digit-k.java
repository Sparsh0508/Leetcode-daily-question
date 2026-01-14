class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
        for(int i = 1;i<=10;i++){
            int sum = i * k;
            if(sum > num){
                break;
            }
            if((num - sum) % 10 == 0){
                return i;
            }
        }
        return -1;
    }
}