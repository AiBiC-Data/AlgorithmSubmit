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
		arr = new int[N][N];  # 비용 저장할 2차원 배열
		nums = new int[N];	# 방문할 순서를 저장할 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];	# 방문 한 도시
		ans = Integer.MAX_VALUE;
		perm(0,0);	# TSP는 모두 순환 할 것이므로 순열로 줄을 세운다
		System.out.println(ans);
	}
	static void perm(int dep, int flag) {	# 비트마스킹을 이용한 순열 코드
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
# TSP를 인식한 순간 어차피 전부 방문해야 한다.
# 순열을 이용해서 순서를 정하고 마지막에 계산하면 되는데
# 시간을 조금이라도 줄이려면 NP사용하면 된다.
