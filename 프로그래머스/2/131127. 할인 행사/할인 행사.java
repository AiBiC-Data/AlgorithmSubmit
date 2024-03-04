import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hmap = new HashMap();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            hmap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++)
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        
        if (check(hmap, map)) answer++;
        
        for (int i = 1; i < discount.length - 9; i++) {
            String previousKey = discount[i - 1];
            int end = i + 9;
            map.put(previousKey, map.getOrDefault(previousKey, 0) - 1);
            if (map.get(previousKey) == 0)
                map.remove(previousKey);
            map.put(discount[end], map.getOrDefault(discount[end], 0) + 1);

            if (check(hmap, map)) answer++;

        }
        
        return answer;
    }
    
    static boolean check(HashMap<String,Integer> t, HashMap<String,Integer> m) {
        for (String key: m.keySet()) {
            if (!t.containsKey(key) || m.get(key) != t.get(key))
                return false;
        }
        return true;
    }
}