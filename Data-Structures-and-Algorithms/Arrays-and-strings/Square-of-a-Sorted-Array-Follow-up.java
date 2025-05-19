class Solution {
    // time = O(n) =>walk through array and squares and stores and two arrays and after walk through those two and store in the original array using a merge strategy
    // space = O(2*n) => O(n) => store negative non negative squares
    public int[] sortedSquares(int[] nums) {
        // space => O(n)
        int [] numsNonNeg = new int[nums.length];
        // space => O(n)
        int [] numsNeg = new int[nums.length];
        
        // space => O(2) => O(1)
        int nonNegSize = 0;
        int negSize = 0;
        
        // time => O(n)
        for(int i=0;i<nums.length;i++) {
            if (nums[i] < 0) {
                numsNeg[negSize] = nums[i]*nums[i];
                negSize++;
            } else {
                numsNonNeg[nonNegSize] = nums[i]*nums[i];
                nonNegSize++;
            }
        }
        
        // space => O(3) => O(1)
        int iNonNeg = 0;
        int iNeg = negSize-1;
        int i = 0;
        
        // time => O(n)
        while (iNonNeg<nonNegSize && iNeg>=0) {
            if (numsNeg[iNeg]<=numsNonNeg[iNonNeg]) {
                nums[i] = numsNeg[iNeg];
                iNeg--;
            } else {
                nums[i] = numsNonNeg[iNonNeg];
                iNonNeg++;
            }
            i++;
        }
        
        // time => O(n)
        while(iNonNeg<nonNegSize) {
            nums[i] = numsNonNeg[iNonNeg];
            iNonNeg++;
            i++;
        }
        
        // time => O(n)
        while(iNeg>=0) {
            nums[i] = numsNeg[iNeg];
            iNeg--;
            i++;
        }
        return nums;
    }
}