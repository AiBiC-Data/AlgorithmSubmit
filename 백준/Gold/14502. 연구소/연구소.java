import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], tmp[][], size, ans = 0;
	static ArrayList<int[]> alist, qlist;
	static Queue<int[]> q;
	static int put[];
	static StringTokenizer st;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		alist = new ArrayList<>();
		qlist = new ArrayList<>();

		map = new int[N][M];
		tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					alist.add(new int[] { i, j });
				else if (map[i][j] == 2)
					qlist.add(new int[] { i, j });
			}
		}
		
		size = alist.size();
		put = new int[3];
		comb(0, 0);
		System.out.println(ans);

	}

	private static void comb(int dep, int flag) {
		if (dep == 3) {
			ans = Math.max(ans, check());
			return;
		}
		
		for (int i = flag; i < size; i++) {
			put[dep] = i;
			comb(dep + 1, i + 1);
		}
	}

	private static int check() {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			int[] tmp = alist.get(put[i]);
			map[tmp[0]][tmp[1]] = 1;
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
			map[i] = Arrays.copyOf(tmp[i], M);
		}
		
		return cnt;
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		q = new LinkedList<>(qlist);
		visited[q.peek()[0]][q.peek()[1]] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
					continue;
				if (map[nx][ny] != 0)
					continue;
				
				map[nx][ny]=2;
				q.add(new int[] { nx, ny });
				visited[nx][ny] = true;
			}
		}
	}
}