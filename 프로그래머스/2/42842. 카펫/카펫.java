import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int half = sum/2+1;
        for(int i=3; i<half; i++){
            if(sum%i==0){
                int j= sum/i;
                int yel = (i-2) * (j-2);
                if( j>=3 && yel==yellow){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
            
        }
        return answer;
    }
}