import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hmap = new HashMap();
        int cnt =record.length;
        
        for(int i=0; i< record.length; i++){
            String[] tmp = record[i].split(" ");
            
            if(tmp[0].equals("Enter")){
                hmap.put(tmp[1], tmp[2]);
            }else if(tmp[0].equals("Change")){
                hmap.put(tmp[1], tmp[2]);
                cnt--;
            }
        }
        
        String[] answer = new String[cnt];
        
        for(int i=0, idx=0; i< record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter"))
                answer[idx++] = hmap.get(tmp[1]) +"님이 들어왔습니다.";
            else if(tmp[0].equals("Leave"))
                answer[idx++] = hmap.get(tmp[1]) +"님이 나갔습니다.";
        }
        
        return answer;
    }
}