class Solution {
    private boolean check(int[] nums, int threshold, int divisor) {
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += Math.ceil((double)nums[i]/divisor);
        }
        return sum <= threshold;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
        }
        int left = 1;
        int right = max;
        int mid, ans = 0;
        while(left<=right) {
            mid = left + ((right-left)/2);
            if(check(nums,threshold,mid)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}