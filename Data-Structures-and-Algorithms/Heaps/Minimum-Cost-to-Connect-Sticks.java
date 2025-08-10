class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        int sum = 0, value;
        for(int i=0;i<sticks.length;i++) {
            heap.add(sticks[i]);
        }
        while(heap.size()>1) {
            value = heap.poll()+heap.poll(); 
            sum += value;
            heap.add(value);
        }
        return sum;
    }
}