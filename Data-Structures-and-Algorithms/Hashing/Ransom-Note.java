class Solution {
    // n => length of ransomNote
    // m => length of magazine
    // O(n+m)
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteCount = new HashMap();
        Map<Character, Integer> magazineCount = new HashMap();
        boolean ans = true;
        int temp = 0;
        for(int i=0;i<ransomNote.length();i++) { // O(n)
            temp = ransomNoteCount.getOrDefault(ransomNote.charAt(i), 0);
            ransomNoteCount.put(ransomNote.charAt(i), temp+1);
        }
        for(int i=0;i<magazine.length();i++) { // O(m)
            temp = magazineCount.getOrDefault(magazine.charAt(i), 0);
            magazineCount.put(magazine.charAt(i), temp+1);
        }
        for(Character key:ransomNoteCount.keySet()){ // O(26) => O(1)
            ans = ans && magazineCount.getOrDefault(key,0) >= ransomNoteCount.get(key); // O(1)
        }
        return ans;
    }
}