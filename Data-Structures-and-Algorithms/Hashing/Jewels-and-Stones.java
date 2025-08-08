class Solution {
    // n => length of jewels
    // m => length of stones
    // O(n+m)
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewelsCount = new HashMap();
        Map<Character, Integer> stonesCount = new HashMap();
        int ans = 0;
        int temp = 0;
        for(int i=0;i<jewels.length();i++) { // O(n)
            temp = jewelsCount.getOrDefault(jewels.charAt(i), 0);
            jewelsCount.put(jewels.charAt(i), temp+1);
        }
        for(int i=0;i<stones.length();i++) { // O(m)
            temp = stonesCount.getOrDefault(stones.charAt(i), 0);
            stonesCount.put(stones.charAt(i), temp+1);
        }
        for(Character key:jewelsCount.keySet()){ // O(52) => O(1)
            ans += stonesCount.getOrDefault(key,0); // O(1)
        }
        return ans;
    }
}