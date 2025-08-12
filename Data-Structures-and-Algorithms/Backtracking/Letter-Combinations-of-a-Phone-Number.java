class Solution {
    
    private void backtracking(String s, int p, char[][] mapNumbersToLetters, List<String> result, StringBuilder curr) {
        if (p==s.length()) {
            result.add(curr.toString());
            return;
        }
        int digit = s.charAt(p)-'0';
        for(int i=0;i<mapNumbersToLetters[digit].length;i++) {
            curr.append(mapNumbersToLetters[digit][i]);
            backtracking(s,p+1,mapNumbersToLetters,result,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        char[][] mapNumbersToLetters = new char[10][];
        mapNumbersToLetters[2] = new char[]{'a','b','c'};
        mapNumbersToLetters[3] = new char[]{'d','e','f'};
        mapNumbersToLetters[4] = new char[]{'g','h','i'};
        mapNumbersToLetters[5] = new char[]{'j','k','l'};
        mapNumbersToLetters[6] = new char[]{'m','n','o'};
        mapNumbersToLetters[7] = new char[]{'p','q','r', 's'};
        mapNumbersToLetters[8] = new char[]{'t','u','v'};
        mapNumbersToLetters[9] = new char[]{'w','x','y', 'z'};
        List<String> result = new ArrayList();
        if (digits.length()>0) {
            backtracking(digits,0,mapNumbersToLetters,result,new StringBuilder());
        }
        return result;
    }
}