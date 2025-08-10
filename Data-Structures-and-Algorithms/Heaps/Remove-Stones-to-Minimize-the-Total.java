class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue(Comparator.reverseOrder());
        int sum = 0;
        for(int i=0;i<piles.length;i++) {
            sum += piles[i];
            heap.add(piles[i]);
        }
        while(k>0) {
            k--;
            int value = heap.poll();
            sum -= value;
            value = value - (value/2);
            sum += value;
            heap.add(value);
        }
        return sum;
    }
}