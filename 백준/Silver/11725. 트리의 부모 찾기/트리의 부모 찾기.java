import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] parents;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		parents = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);

		for (int i = 2; i < N + 1; i++) {
			System.out.println(parents[i]);
		}

	}

	private static void dfs(int i) {
		visited[i] = true;
		for (int l : list[i]) {
			if (!visited[l]) {
				parents[l] = i;
				dfs(l);
			}
		}

	}
}