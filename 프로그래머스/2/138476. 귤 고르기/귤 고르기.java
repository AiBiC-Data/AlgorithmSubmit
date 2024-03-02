import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 1;
        
        HashMap<Integer, Integer> hmap = new HashMap();
        for(int t: tangerine){
            hmap.put(t, hmap.getOrDefault(t, 0)+1);
        }
        
        ArrayList<Integer> aList = new ArrayList<>(hmap.values());
        aList.sort((o1,o2)->o2-o1);
        
        for (int a : aList) {
            if (sum + a >= k) {
                break;
            }
            sum += a;
            cnt++;
        }
        
        return cnt;
    }
}