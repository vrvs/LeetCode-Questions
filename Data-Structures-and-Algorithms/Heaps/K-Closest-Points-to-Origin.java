class Solution {
    
    private class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        double distance() {
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<Point>((p1,p2) -> {
            return (((p2.distance() - p1.distance()) == 0.0) ? 0 : (((p2.distance() - p1.distance()) > 0) ? 1 : -1));
        });
        int[][] result = new int[k][2];
        for(int i=0;i<points.length;i++) {
            heap.add(new Point(points[i][0],points[i][1]));
            if(heap.size()>k) {
                heap.poll();
            }
        }
        Point point;
        for(int i=0;i<k;i++) {
            point = heap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }
}