import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int size = clothes.length;
        for(int i=0; i<size; i++){
            hmap.put(clothes[i][1], hmap.getOrDefault(clothes[i][1], 0)+1);
        }
        
        int cnt=1;
        for(String key: hmap.keySet()){
            System.out.println(hmap.get(key));
            cnt*=(hmap.get(key)+1);
        }
        return cnt-1;
    }
}