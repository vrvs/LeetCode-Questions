class KthLargest {
    
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue();
        this.k = k;
        for(int i=0;i<nums.length;i++) {
            heap.add(nums[i]);
            if (heap.size()>k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size()>k) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */