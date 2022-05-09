package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new custom());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new int[]{e.getValue(),e.getKey()});
        }
        List<Integer> a = new ArrayList<>();
        while(!pq.isEmpty() && k != 0){
            
            int[] rp = pq.poll();
            a.add(rp[1]);
            k--;
        }
        int[] ans = new int[a.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = a.get(i);
        }
        return ans;
    }
    class custom implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return b[0] - a[0];
        }
    }
}
