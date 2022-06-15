class CountIntervals {
    TreeMap<Integer,Integer> map;
    int count = 0;
    public CountIntervals() {
        map = new TreeMap<>();
    }
    
    public void add(int left, int right) {
       int cnt = 0;
     
        int l = left, r = right;
        while(true){
                    
         if(map.floorKey(r) == null || map.get(map.floorKey(r)) < l) break;
         int key = map.floorKey(r);
         int val = map.get(key);
  
         count = count - (val - key + 1);
         map.remove(key);
                    
         l = Math.min(l,key);
                    
         r = Math.max(r,val);
 
        }
        count += r - l + 1 ;
   
        map.put(l,r);
    }
    
    public int count() {
        return count;
    }
}
