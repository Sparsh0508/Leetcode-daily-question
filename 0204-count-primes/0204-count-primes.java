class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }   
        
        // First Approach
        // int cnt = 1;
        // for(int i = 3;i<n;i++){
        //     if(i % 2 == 0){
        //         continue;
        //     }else if(isPrime(i)){
        //         cnt++;
        //     }
        // }
        // return cnt;

        // Second Approach

             
        boolean prime[] = new boolean[n];
        int count = 0;
        for(int i = 3; i < n; i+=2){
            prime[i] = true;
        }
        for(int i = 3; i * i < n; i+=2){
            if(prime[i]){
                for(int j = i * i; j < n; j += 2*i){
                    prime[j] = false;
                }
            }
        }
        count = 1; 
        for(int i = 3; i < n; i+=2){
            if(prime[i]){
                count++;
            }
        }
        return count;
    }

    // public static boolean isPrime(int n){
    //     for (int i = 3; i * i <= n; i += 2) {
    //         if (n % i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}