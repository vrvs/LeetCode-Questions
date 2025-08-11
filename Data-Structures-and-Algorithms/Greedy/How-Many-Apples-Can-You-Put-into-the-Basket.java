class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0, total = 0;
        for(int i=0;i<weight.length;i++) {
            if (total+weight[i]<=5000) {
                total += weight[i];
                ans++;
            }
        }
        return ans;
    }
}