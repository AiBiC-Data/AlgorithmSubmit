import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N + 1][N + 1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				num[i][j] = Integer.parseInt(st.nextToken())+num[i][j-1];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if (x==0) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int tmp = c-(num[x1][y1]-num[x1][y1-1]);
				for (int j = y1; j < N+1; j++) {
					num[x1][j]+=tmp;
				}

			}else {
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum=0;
			for (int j = x1; j < x2+1; j++) {
				sum+=num[j][y2]-num[j][y1-1];
			}
			System.out.println(sum);
			}
		}

	}
}
