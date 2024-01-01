import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sum, ans;
	static ArrayList<Integer>[] friends;
	static int[] visited;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N + 1];
		sum = Integer.MAX_VALUE;

		for (int i = 0; i < N + 1; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends[a].add(b);
			friends[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			bfs(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb.toString());
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		visited[i] = -1;
		int cnt = 1;
		while (!q.isEmpty()) {
			int siz = q.size();
			while (siz-- > 0) {
				int num = q.poll();
				for (int j = 0, size = friends[num].size(); j < size; j++) {
					int tmp = friends[num].get(j);
					if (visited[tmp] == 0) {
						q.add(tmp);
						visited[tmp] = cnt;
					}
				}
			}
			cnt++;
		}
		int num = 1;
		for (int j = 1; j < N + 1; j++) {
			num += visited[j];
		}
		if (sum > num) {
			ans = i;
			sum = num;
		}
	}
}