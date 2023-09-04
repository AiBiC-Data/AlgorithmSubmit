import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
		}
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList();
		q.add(x);
		visited[x] = true;

		int cnt = 0;
		while (cnt++ < k) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int tmp = q.poll();
				for (int j = 0, end = graph[tmp].size(); j < end; j++) {
					int ad = (int) graph[tmp].get(j);
					if(!visited[ad]) {
						q.add(ad);
						visited[ad] = true;
					}
				}
			}
		}
		if (q.isEmpty())
			System.out.println(-1);
		else {
			int s = q.size();
			int[] alist = new int[s];
			for (int i = 0; i < s; i++) {
				alist[i] = q.poll();
			}
			Arrays.sort(alist);
			for (int a : alist) {
				System.out.println(a);
			}
		}
	}

}