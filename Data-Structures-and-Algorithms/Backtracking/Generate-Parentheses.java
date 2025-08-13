class Solution {
    
    private void generateParenthesis(int n, StringBuilder curr, int open, int close, List<String> result) {
        if (curr.length()==(n*2)&&open==n&&close==n) {
            result.add(curr.toString()); 
            return;
        }
        if (close > open || close > n || open > n) {
            return;
        }
        if (open == close) {
            curr.append("(");
            generateParenthesis(n, curr, open+1, close, result);
            curr.deleteCharAt(curr.length()-1);
        } else {
            curr.append("(");
            generateParenthesis(n, curr, open+1, close, result);
            curr.deleteCharAt(curr.length()-1);
            curr.append(")");
            generateParenthesis(n, curr, open, close+1, result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParenthesis(n, new StringBuilder(), 0, 0, result);
        return result;
    }
}