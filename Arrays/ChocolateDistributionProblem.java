import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public long findMinDiff(ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(j < n){
            if(j < i + m - 1) j++;
            else if(j == i + m -1){
                min = Math.min(min, a.get(j) - a.get(i));
                i++;
                j++;
            }
        }
        return min;
    }
    
}
