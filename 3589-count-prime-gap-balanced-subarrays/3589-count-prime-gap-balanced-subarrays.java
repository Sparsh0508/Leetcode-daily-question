class Solution {
    boolean[] isPrime = new boolean[50001];
    public void isSieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i *i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public int primeSubarray(int[] nums, int k) {
        isSieve();

        int left = 0, right = 0;
        int res = 0;

        int prev = -1, curr = -1; 
        int primeCount = 0;

        TreeMap<Integer, Integer> hm = new TreeMap<>();

        while (right < nums.length) {
            if (nums[right] < isPrime.length && isPrime[nums[right]]) {
                prev = curr;
                curr = right;

                primeCount++;
                hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            }
            
            while (!hm.isEmpty() && hm.lastKey() - hm.firstKey() > k) {
                if (nums[left] < isPrime.length && isPrime[nums[left]]) {
                    primeCount--;

                    hm.put(nums[left], hm.get(nums[left]) - 1);
                    if (hm.get(nums[left]) == 0) {
                        hm.remove(nums[left]);
                    }
                }
                left++;
            }
            if (primeCount >= 2) {
                res += prev - left + 1;
            }

            right++;
        }
        return res;
    }
}
