import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = rec(n);
        return ans;
    }
    public int rec(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        
        if(n%2==0){
            return rec(n/2);
        }else{
            return rec(n/2)+1;
        }
    }
}