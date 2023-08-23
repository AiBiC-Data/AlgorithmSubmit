import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, S, ans;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			list = new ArrayList[101];
			visited = new boolean[101];
			for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			sol(S);
			sb.append("#" + tc + " "+ans + "\n");
		}
		System.out.println(sb);
	}

	private static void sol(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[s] = true;
		q.offer(s);
		while (!q.isEmpty()) {
			ans = -1;
			for (int i = 0, end = q.size(); i < end; i++) {
				int tmp = q.poll();
				ans = Math.max(ans, tmp);
				for (int j = 0, fin = list[tmp].size(); j < fin; j++) {
					int ud = (int) list[tmp].get(j);
					if (!visited[ud]) {
						q.offer(ud);
						visited[ud] = true;
					}
				}
			}
		}
	}

}