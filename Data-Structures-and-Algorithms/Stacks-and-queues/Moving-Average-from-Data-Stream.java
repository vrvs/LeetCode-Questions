class MovingAverage {

    Queue<Integer> queue;
    double sum;
    int size;
    
    public MovingAverage(int size) {
        queue = new LinkedList();
        sum = 0.0;
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size()==size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */