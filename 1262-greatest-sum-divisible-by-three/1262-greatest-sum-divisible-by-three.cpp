class Solution {
public:
    int help(vector<int>& nums, vector<vector<int>>& dp, int idx, int rem) {
        if (idx == nums.size()){
            return rem == 0 ? 0 : INT_MIN;
        }
        if (dp[idx][rem] != -1){
            return dp[idx][rem];
        }
        int take = INT_MIN;
        int next = help(nums, dp, idx + 1, (rem + nums[idx]) % 3);
        if (next != INT_MIN){
            take = nums[idx] + next;
        }
        int skip = help(nums, dp, idx + 1, rem);
        return dp[idx][rem] = max(take, skip);
    }
    int maxSumDivThree(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(3, -1));
        return help(nums, dp, 0, 0);
    }
};