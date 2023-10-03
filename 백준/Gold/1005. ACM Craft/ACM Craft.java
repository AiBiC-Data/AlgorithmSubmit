import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static long ans;
	static int[] structure;
	static ArrayList[] nodes;
	static long[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 0;
			structure = new int[N+1];
			visited = new long[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				structure[i] = Integer.parseInt(st.nextToken());
			}
			nodes = new ArrayList[N + 1];
			for (int k = 1; k < N + 1; k++) {
				nodes[k] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodes[b].add(a);
			}
			int r = Integer.parseInt(br.readLine());
			for (int i = 0; i < N+1; i++) {
				visited[i] = -1;
			}
			long ans = dfs(r);
			System.out.println(ans);
		}
	}

	private static long dfs(int r) {
		if(visited[r] !=-1) return visited[r];
		long cnt=0;
		for(int tmp=0, end = nodes[r].size(); tmp<end; tmp++) {
			cnt = Math.max(cnt,  dfs((int) nodes[r].get(tmp)));
		}
		cnt +=structure[r];
		return visited[r] = cnt;
	}
}