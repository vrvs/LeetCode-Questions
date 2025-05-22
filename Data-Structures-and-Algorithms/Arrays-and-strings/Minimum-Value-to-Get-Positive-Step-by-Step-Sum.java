class Solution {
    
    // time => O(n)
    public int minStartValue(int[] nums) {
        int ans = 0;
        ans = Math.min(nums[0], ans);
        for (int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            ans = Math.min(ans, nums[i]);
        }
        return Math.abs(ans)+1;
    }
}