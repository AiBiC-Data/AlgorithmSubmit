import java.util.*;

class Solution {
    static ArrayList<int[]> alist = new ArrayList();
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        int size = alist.size();
        int[][] answer = new int[size][2];
        int idx =0;
        for(int[] a:alist) answer[idx++] = a; 
        return answer;
    }
    public void hanoi(int n, int a, int b, int c){
        if(n==0) return;
        
        hanoi(n-1, a, c, b);
        alist.add(new int[]{a,c});
        hanoi(n-1, b, a, c);
    }
}