public class GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curr_tank = 0;
            int start = 0;
            int total = 0;
            
            for(int i = 0; i < gas.length; i++){
                total += gas[i] - cost[i];
                
                curr_tank += gas[i] - cost[i];
                
                if(curr_tank < 0){
                    start = i + 1;
                    curr_tank = 0;
                }
            }
            if(total >= 0) return start;
            return -1;
        }
    }
}
