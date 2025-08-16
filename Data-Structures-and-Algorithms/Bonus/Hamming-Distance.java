class Solution {
    public int hammingDistance(int x, int y) {
        int bitsDiff = x^y;
        int result = 0;
        while(bitsDiff>0) {
            result += (bitsDiff&1);
            bitsDiff = bitsDiff >> 1;
        }
        return result;
    }
}