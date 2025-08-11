class Solution {
    
    private class Box {
        int numberOfBoxes, numberOfUnitsPerBox;
        Box(int numberOfBoxes, int numberOfUnitsPerBox) {
            this.numberOfBoxes = numberOfBoxes;
            this.numberOfUnitsPerBox = numberOfUnitsPerBox;
        }
    }
    
    private class BoxComparator implements Comparator<Box> {
        public int compare(Box b1, Box b2) {
            return b2.numberOfUnitsPerBox-b1.numberOfUnitsPerBox;
        }
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Box[] boxs = new Box[boxTypes.length];
        for(int i=0;i<boxTypes.length;i++) {
            boxs[i] = new Box(boxTypes[i][0],boxTypes[i][1]);
        }
        Arrays.sort(boxs,new BoxComparator());
        int ans = 0;
        int i = 0;
        while(truckSize>0&&i<boxs.length) {
            int boxNumber = Math.min(truckSize,boxs[i].numberOfBoxes);
            ans += (boxs[i].numberOfUnitsPerBox*boxNumber);
            i++;
            truckSize -= boxNumber;
        }
        return ans;
    }
}