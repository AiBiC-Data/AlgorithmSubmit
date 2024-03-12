import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> alist = new ArrayList();
        LinkedList<Integer> q = new LinkedList();
        LinkedList<Integer> q2 = new LinkedList();
        
        for(int p: progresses) q.add(p);
        for(int s: speeds) q2.add(s);
        
        while(!q.isEmpty()){
            int plus = q2.poll();
            int start = q.poll()+plus;
            int size = q.size();
            boolean flag=false;
            int cnt =0;
            if(start>=100) {
                flag=true;
                cnt++;
            }else{
                q.add(start);
                q2.add(plus);
            }
            for(int s=0; s<size; s++){
                int p = q2.poll();
                int t=q.poll()+p;
                if(flag){
                    if(t>=100) {
                        cnt++;
                        continue;
                    }
                    flag=false;
                }
                q.add(t);
                q2.add(p);
            }
            if(cnt!=0) alist.add(cnt);
        }
        int alen = alist.size();
        int[] answer = new int[alen];
        int idx=0;
        for(int a: alist){
            answer[idx++] = a;
        }
        return answer;
    }
}