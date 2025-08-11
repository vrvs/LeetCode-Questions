class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> hash = new HashMap();
        for(int i=0;i<arr.length;i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        List<Integer> occurrences = new ArrayList(hash.keySet().size());
        for(int key:hash.keySet()) {
            occurrences.add(hash.get(key));
        }
        occurrences.sort(Comparator.reverseOrder());
        int counter = 0, ans = 0;
        for(int i=0;i<occurrences.size();i++) {
            counter += occurrences.get(i);
            ans++;
            if(counter>=Math.ceil((double)arr.length/2.0)) {
                break;
            }
        }
        return ans;
    }
}