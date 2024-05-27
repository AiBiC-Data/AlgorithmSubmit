import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static boolean[][] arr;
    static HashMap<String, int[]> hmap = new HashMap<>(); 
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[10][7];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int[] tmp = new int[3];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());
            hmap.put(name, tmp);
        }
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            if(hmap.containsKey(target) && hmap.get(target)[2]>Integer.parseInt(st.nextToken())) hmap.remove(target);
        }
        
        for(int[] days : hmap.values()){
            int x = days[0]-1;
            int y = days[1];
            arr[x][y] = true;
        }
        
        int ans=0;
        int cnt=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<7; j++){
                if(arr[i][j]) cnt++;
                else cnt=0;
                ans = Math.max(cnt, ans);
            }
        }
        System.out.print(ans);
    }
}
