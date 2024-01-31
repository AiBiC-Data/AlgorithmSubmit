import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        int size = works.length;
        for(int i=0; i<size; i++){
            pq.add(-works[i]);
        }
        
        int num =0;
        for(int i=0; i<n; i++){
            num = pq.poll();
            if(num==0) break;
            pq.add(num+1);
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}