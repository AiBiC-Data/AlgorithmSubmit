import java.util.*;

class Solution {
    static int answer = 0;
    static int N;
    static int[] nums;
    static int[] res;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = i;
        }
        res = new int[N];
        perm(0,0, k, dungeons);
        return answer;
    }
    
    public static void perm(int dept, int flag, int k, int[][] d){
        if(dept == N){
            int tmp =0;
            for(int i=0; i<N; i++){
                if(k>=d[res[i]][0]){
                    k-=d[res[i]][1];
                    tmp++;
                }
            }
            answer = Math.max(answer, tmp);
            return;
        }
        for(int i=0; i<N; i++){
            if((flag&1<<i)!=0) continue;
            res[dept] = nums[i];
            perm(dept+1, flag|1<<i, k, d);
        }
    }
}