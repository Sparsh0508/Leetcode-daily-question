class Solution {
    public int countEven(int num) {
        if(num < 2){
            return 0;
        }
        int cnt = 0;
        for(int i = 2;i<=num;i++){
            if(isEven(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean isEven(int n){
        int sum = 0;
        while(n > 0){
            int rem = n% 10;
            sum += rem;
            n /= 10;
        }
        return sum%2==0 ? true : false;
        
    }
}