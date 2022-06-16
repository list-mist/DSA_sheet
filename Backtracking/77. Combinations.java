class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> t = new ArrayList<>();
        
        generate(t,ans,n,k,1);
        
        return ans;
 
    }
    
    void generate(List<Integer> sub, List<List<Integer>> ans,int n,int k,int idx){
        if(sub.size() == k){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i = idx; i <= n && idx <= n; i++){
            sub.add(i);
            generate(sub,ans,n,k,i + 1);
            sub.remove(sub.size() - 1);

        }
    }
}
