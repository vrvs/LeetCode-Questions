class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
        int left, right, mid, target;
        for(int i=0;i<queries.length;i++) {
            left = 0;
            right = nums.length-1;
            target = queries[i];
            while(left<=right) {
                mid = left + ((right-left)/2);
                if (target >= nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            queries[i] = left;
        }
        return queries;
    }
}