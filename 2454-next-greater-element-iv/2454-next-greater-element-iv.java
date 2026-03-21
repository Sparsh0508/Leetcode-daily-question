class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                res[s2.pop()] = nums[i];
            }
            Stack<Integer> temp = new Stack<>();
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                temp.push(s1.pop());
            }
            while (!temp.isEmpty()) {
                s2.push(temp.pop());
            }
            s1.push(i);
        }

        return res;
    }
}