class Solution {
    // n => length of s
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> counter = new HashMap();
        int temp = 0;
        int ans = 0;
        int left = 0;
        // O(n+n) => O(n)
        // because right pass through the string once, and left pass through the string once
        for(int right=0;right<s.length();right++) {
            temp = counter.getOrDefault(s.charAt(right),0);
            if (temp==0) {
                counter.put(s.charAt(right),1); //
            } else {
                while(s.charAt(left)!=s.charAt(right)) {
                    counter.put(s.charAt(left),0);
                    left++;
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}