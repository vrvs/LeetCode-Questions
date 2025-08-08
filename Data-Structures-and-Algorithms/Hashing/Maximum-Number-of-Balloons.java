class Solution {
    // n => text length
    // O(n)
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counter = new HashMap();
        int temp = 0;
        for(int i=0;i<text.length();i++){ // O(n)
            temp = counter.getOrDefault(text.charAt(i), 0); // O(1)
            counter.put(text.charAt(i), temp+1); // O(1)
        }
        String balloon = "balloon";
        int result = Integer.MAX_VALUE;
        Map<Character, Integer> counterBalloon = new HashMap();
        for(int i=0;i<balloon.length();i++){  // O(7) => O(1)
            temp = counterBalloon.getOrDefault(balloon.charAt(i), 0); // O(1)
            counterBalloon.put(balloon.charAt(i), temp+1); // O(1)
        }
        for(Character key:counterBalloon.keySet()){ // O(7) => O(1)
            result = Integer.min(
                result, 
                counter.getOrDefault(key,0)/counterBalloon.get(key) // O(1)
            );
        }
        return result;
    }
}