import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<priorities.length; i++){
            pq.add(-priorities[i]);
        }
        
        Queue<Process> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.add(new Process(priorities[i], i));
        }
        
        int cnt=0;
        while(true){
            int tmp = -1*pq.poll();
            Process process = q.poll();
            
            if(tmp==process.p){
                cnt++;
                if(location==process.idx) return cnt;
            }else{
                pq.add(-1*tmp);
                q.add(process);
            }
        }
    }
    
    class Process {
        int p, idx;
        
        Process(int p, int idx){
            this.p = p;
            this.idx = idx;
        }
    }
}