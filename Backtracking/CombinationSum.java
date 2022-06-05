
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> set = new ArrayList<>();
            
            fun(res,set,n,k,0,1);
            
            return res;
        }
        void fun(List<List<Integer>> res, List<Integer> set, int n, int k,int sum,int idx){
            if(n == 0 && set.size() == k){
             
                Collections.sort(set);
                if(res.contains(set)) return;
                res.add(new ArrayList<>(set));
                return;
            }
            if(k <= 0 || n <= 0) return;
            for(int i = idx; i < 10 ; i++){
                if(i > n) break;
                if(set.contains(i)) continue;
                set.add(i);
                fun(res,set,n - i, k , sum , idx + 1);
                set.remove(set.indexOf(i));
            }
           
        }
    }

