import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hset = new HashSet();
        int size = elements.length;
        int[] arr = new int[size*2];
        for(int i=0; i<size; i++){
            arr[i] = elements[i];
            arr[i+size] = elements[i];
        }
        for(int i=0; i<size; i++){
            int cnt=0;
            for(int j=0; j<size; j++){
                cnt+=arr[i+j];
                hset.add(cnt);
            }
        }
        return hset.size();
    }
}