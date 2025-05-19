class Solution {
    // time = O(n) O(n*log(n)) => O(n*log(n))=>walk through array O(n) and sort O(n*log(n))
    // space = O(1) => only used the input array
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}