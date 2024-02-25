import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] time = new int[n];
        HashMap<String, Integer> hmap = new HashMap();
        int c=0;
        int cnt=0;
        char ch = 'A';
        
        while(cnt<words.length){
            if(cnt==0){
                hmap.put(words[cnt], 1);
                time[c]+=1;
                ch = words[cnt].charAt(words[cnt].length()-1);
                c++;
                cnt++;
                continue;
            }
            if(hmap.containsKey(words[cnt]) || words[cnt].charAt(0)!=ch){
                answer[0] = c+1;
                answer[1] = time[c]+1;
                break;
            }else{
                hmap.put(words[cnt], 1);
                time[c]+=1;
                ch = words[cnt].charAt(words[cnt].length()-1);
            }
            if(c==n-1)
                c=0;
            else c++;
            cnt++;
        }
        
        return answer;
    }
}