class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while(num/10 != 0){
            sum = 0;
            while(num > 0){
                int rem = num % 10;
                sum += rem;
                num /= 10;
            }
            if(sum/10 == 0){
                return sum;
            }else{
                num = sum;
            }
        }
        return num;
    }
}