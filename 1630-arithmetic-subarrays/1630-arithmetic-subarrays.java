class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> al = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int a = l[i];
            int b = r[i];
            
            int[] arr = new int[b - a + 1];
            for (int j = a, m = 0; j <= b; j++, m++) {
                arr[m] = nums[j];
            }
            Arrays.sort(arr);

            int d = arr[1] - arr[0];
            boolean ok = true;
            for (int k = 2; k < arr.length; k++) {
                if (arr[k] - arr[k - 1] != d) {
                    ok = false;
                    break;
                }
            }

            al.add(ok);
        }
        return al;
    }
}
