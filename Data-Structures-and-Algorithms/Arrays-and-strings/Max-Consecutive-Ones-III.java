class Solution {
    // time => O(n)
    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, right = 0;
        while (left<=right && right<nums.length) {
            if (nums[right]==1 || (nums[right]==0 && k>0)) {
                if (nums[right]==0) {
                    k--;
                }
                right++;
                ans = Math.max(right-left, ans);
            } else {
                while (nums[left]==1 && left < right) {
                    left++;
                }
                if (left < right) {
                    k++;
                }
                left++;
                if (left > right) {
                    right++;
                }
            }
        }
        return ans;
    }
}