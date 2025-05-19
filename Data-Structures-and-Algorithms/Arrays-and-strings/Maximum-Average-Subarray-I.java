class Solution {
    // time => O(n)
    public double findMaxAverage(int[] nums, int k) {
        for (int i=1;i<nums.length;i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        int j = 0;
        double ans = 0.0, avrg = 0.0;
        for(int i=k-1;i<nums.length;i++) {
            j = i-k;
            if(j<0) {
                ans = ((double)nums[i])/k;
            } else {
                avrg = ((double)nums[i]-nums[j])/k;
                if (avrg > ans) {
                    ans = avrg;
                }
            }
        }
        return ans;
    }
}