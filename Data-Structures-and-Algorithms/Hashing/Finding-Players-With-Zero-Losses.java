class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap();
        int lossesWinner, lossesLoser;
        for(int i=0;i<matches.length;i++) {
            lossesWinner = losses.getOrDefault(matches[i][0], 0);
            lossesLoser = losses.getOrDefault(matches[i][1], 0);
            losses.put(matches[i][0], lossesWinner);
            losses.put(matches[i][1], lossesLoser+1);
        }
        List<List<Integer>> result = new LinkedList();
        result.add(new LinkedList());
        result.add(new LinkedList());
        for(Integer key:losses.keySet()) {
            if(losses.get(key) == 0) {
                result.get(0).add(key);
            }
            if(losses.get(key) == 1) {
                result.get(1).add(key);
            }
        }
        result.get(0).sort(Comparator.naturalOrder());
        result.get(1).sort(Comparator.naturalOrder());
        return result;
    }
}