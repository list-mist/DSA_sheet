class Solution
{
	public long getCount(int n)
	{
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		map.put(0,Arrays.asList(0,8));
		map.put(1,Arrays.asList(1,2,4));
		map.put(2,Arrays.asList(2,1,3,5));
		map.put(3,Arrays.asList(3,2,6));
		map.put(4,Arrays.asList(4,1,5,7));
		map.put(5,Arrays.asList(5,2,4,6,8));
		map.put(6,Arrays.asList(6,3,5,9));
		map.put(7,Arrays.asList(7,4,8));
		map.put(8,Arrays.asList(8,5,7,9,0));
		map.put(9,Arrays.asList(9,6,8));
		long count = 0;
		long[][] dp = new long[n+1][10];
		for(int i = 0; i < 10; i++){
		    count += getCombination(n,map,1,i,dp);
		}
		return count;
	}
  	long getCombination(int n,HashMap<Integer,List<Integer>> map,int len,int i,long[][] dp){
	    if(len == n) {
	        return 1;
	    }
	    if(dp[len][i] != 0) return dp[len][i];
	    long ans = 0;
	    List<Integer> lis = map.get(i);
	    for(int li : lis)
	    {
	        ans += getCombination(n,map,len+1,li,dp);
	    }
	    return dp[len][i] = ans;
  	}
}
