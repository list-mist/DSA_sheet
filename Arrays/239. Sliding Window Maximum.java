class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<Integer>();  
        int i = 0, j = 0;
        while(j < n){
            if(dq.isEmpty()){
                dq.add(nums[j]);
            }
            else{
                while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                    dq.pollLast();
                }
                dq.addLast(nums[j]);
            }
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                lis.add(dq.getFirst());
                if(dq.peekFirst() == nums[i]){
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        int[] res = new int[lis.size()];
        int idx = 0;
        for(int ele : lis) res[idx++] = ele;
        
        return res;
    }
  
}
