import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashMap> hmap = new HashMap();
        for(int i=0; i< id_list.length; i++){
            hmap.put(id_list[i], new HashMap<String, Integer>()); //String[]이 편했음
        }

        for(int i=0; i< report.length; i++){
            String[] users = report[i].split(" ");
            if(hmap.get(users[1]).get(users[0])==null){
                hmap.get(users[1]).put(users[0], 1);
            }
        }
        int size = hmap.size();
        for(int i=0; i< id_list.length; i++){
            int len = hmap.get(id_list[i]).size();
            if(len>=k){
                for(int j=0; j<id_list.length; j++){
                     if(hmap.get(id_list[i]).get(id_list[j])!=null){
                         answer[j]+=1;
                     }
                }
            }
        }
        return answer;
    }
}