class Solution {
    // n => length of nums
    // O(n)
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSumHash = new HashMap();
        int prefixSum = 0;
        int ans = 0;
        prefixSumHash.put(0,-1); // O(1)
        for(int i=0;i<nums.length;i++){// O(n)
            if(nums[i]==0) {
                prefixSum--;
            } else {
                prefixSum++;
            }
            if(prefixSumHash.containsKey(prefixSum)) { // O(1)
                ans = Math.max(ans, i - prefixSumHash.get(prefixSum));// O(1)
            } else {
                prefixSumHash.put(prefixSum,i);// O(1)
            }
        }
        return ans;
    }
}