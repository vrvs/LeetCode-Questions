class Solution {
    // n => length of s
    // time => O(n)
    // space => O(n)
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++) { // O(n)
            Character c = s.charAt(i);
            int toSum;
            if (c>='a'&&c<='z') {
                toSum = -('A'-'a');
            } else {
                toSum = ('A'-'a');
            }
            if(!stack.empty()) {
                if (c == stack.peek()+toSum) { // O(1)
                    stack.pop(); // O(1)
                } else {
                    stack.push(c); // O(1)
                }
            } else {
                stack.push(c); // O(1)
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c: stack) { // O(n)
            sb.append(c); // O(1)
        }
        return sb.toString();
    }
}