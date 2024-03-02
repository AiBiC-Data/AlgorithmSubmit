import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 1;
        
        HashMap<Integer, Integer> hmap = new HashMap();
        for(int i=0; i<tangerine.length; i++){
            hmap.put(tangerine[i], hmap.getOrDefault(tangerine[i], 0)+1);
        }
        
        ArrayList<Integer> aList = new ArrayList<>(hmap.values());
        Collections.sort(aList, Collections.reverseOrder());
        
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