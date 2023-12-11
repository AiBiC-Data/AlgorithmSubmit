import java.io.*;
import java.util.*;

public class Main {
	static int N,M, ans, res[];
	static ArrayList<Integer> alist = new ArrayList<>();
	static HashMap<String, Integer> hmap;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
	        int n = Integer.parseInt(br.readLine());
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
	        boolean[] v = new boolean[n];
	        int cnt = 0;
	        for (int i = 0; i < n; i++) {
	            if (v[i]) continue;
	            cnt++;
	            int s = i;
	            while (!v[s]) {
	                v[s] = true;
	                s = arr[s];
	            }
	        }
	        System.out.println(cnt==1?0:cnt);
	}
}