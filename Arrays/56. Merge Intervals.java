class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new custom());
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] t : intervals){
            int left = t[0];
            int right = t[1];
            while(true){
                if(map.floorKey(right)== null || map.get(map.floorKey(right)) < left) break;
                
                int prevLeft = map.floorKey(right);
                int prevRight = map.get(prevLeft);
                
                map.remove(prevLeft);
                
                left = Math.min(prevLeft, left);
                right = Math.max(prevRight, right);
            }
            map.put(left,right);
        }
        int[][] mergedInterval = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            mergedInterval[idx][0] = e.getKey();
            mergedInterval[idx][1] = e.getValue();
            idx++;
        }
        return mergedInterval;
    }
    class custom implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}
