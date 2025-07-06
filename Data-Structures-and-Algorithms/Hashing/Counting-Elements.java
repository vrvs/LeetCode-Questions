class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }
        int ans = 0;
        for (int i=0;i<arr.length;i++) {
            if (set.contains(arr[i]+1)) {
                ans++;
            }
        }
        return ans;
    }
}