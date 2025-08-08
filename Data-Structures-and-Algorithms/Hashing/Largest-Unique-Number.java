class Solution {
    // n => length of nums
    // O(n) + O(n) + O(n) => O(n)
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> counter = new HashMap();
        int temp = 0;
        for(int i=0;i<nums.length;i++){ // O(n)
            temp = counter.getOrDefault(nums[i], 0); // O(1)
            counter.put(nums[i], temp+1); // O(1)
        }
        LinkedList<Integer> uniqueNumbers = new LinkedList();
        int result = -1;
        for(Integer key: counter.keySet()){ // O(n)
            if(counter.get(key) == 1) {
                if (result == -1 || key > result) {
                    result = key;
                }
            }
        }
        return result;
    }
}