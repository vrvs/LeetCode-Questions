class Solution {
    // n => length of n
    // time => O(n)
    // space => O(n)
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();
        String directory;
        for (int i=0;i<path.length();i++)  { // O(n)
            if(path.charAt(i)=='/') {
                if(sb.length()>0) {
                    directory = sb.toString(); // Since all the directories are on the String, then we will sum the time complexity in the for loop
                    if (directory.equals("..")) {
                        if(!stack.empty()) {
                            stack.pop(); // O(1)
                        }
                    } else if (!directory.equals(".")) {
                        stack.push(directory); // O(1)
                    }
                    sb = new StringBuilder();
                }
            } else {
                sb.append(path.charAt(i)); // O(1)
            }
        }
        if(sb.length()>0) {
            directory = sb.toString();
            if (directory.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else if (!directory.equals(".")) {
                stack.push(directory);
            }
        }
        sb = new StringBuilder();
        for(String s: stack) { // O(n)
            sb.append("/");
            sb.append(s);
            
        }
        if(stack.empty()) {
            sb.append("/");
        }
        return sb.toString();
    }
}