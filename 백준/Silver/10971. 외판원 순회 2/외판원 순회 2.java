import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans, nums[];
	static boolean[] visited;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		ans = Integer.MAX_VALUE;
		perm(0,0);
		System.out.println(ans);
	}
	static void perm(int dep, int flag) {
		if(dep==N) {
			if(arr[nums[N-1]][nums[0]]>0) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					cnt += arr[nums[i]][nums[(i+1)%N]];
				}
				ans = Math.min(ans, cnt);
			}
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			if (dep > 0 && arr[nums[dep-1]][i] == 0) continue;
			nums[dep] = i;
			perm(dep+1, flag | 1 << i);
		}
	}
}