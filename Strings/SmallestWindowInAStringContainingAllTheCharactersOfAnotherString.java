class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        String ans = "";
        String min = "";
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map1 = new HashMap<>();
        int count = p.length();
        for(char ch : p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i = 0, j = 0, n = s.length(), tc = 0;
        //System.out.println(map);
        while(true){
           boolean f1 = true;
           boolean f2 = true;
           while(j < n && tc < count){
               char ch = s.charAt(j);
               map1.put(ch,map1.getOrDefault(ch,0)+1);
               if(map.getOrDefault(ch,0) >=  map1.getOrDefault(ch,0)){
                  tc++;
               }
                j++;
                f1 = false;
               // System.out.println(tc);
           }
           while(i < j && tc == count){
               min = s.substring(i,j);
             //  System.out.println(min);
               if(ans.length() == 0 || min.length() < ans.length()){
                   ans = min;
               }
               char ch = s.charAt(i);
               int val = map1.getOrDefault(ch,0);
               if(val == 1){
                   map1.remove(ch);
               }
               else{
                   map1.put(ch,val - 1);
               }
               if(map.getOrDefault(ch,0) > map1.getOrDefault(ch,0)){
                   tc --;
               }
               f2 = false;
               i++;
           }
           if(f1 && f2) break;
           
        }
        return ans = ans.length() == 0 ? "-1" : ans ;
    }
}
