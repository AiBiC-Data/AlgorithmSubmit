import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, tc = 1, map[][], dist[][];
	static int INF = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static class Status implements Comparable<Status> {
		int r, c;
		int dist;

		public Status(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Status o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				System.out.println(sb);
				break;
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist = new int[N][N];
			for (int[] d : dist) {
				Arrays.fill(d, INF);
			}
			djikstra();
		}

	}

	static void djikstra() {
		PriorityQueue<Status> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.add(new Status(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Status cur = pq.poll();
			int x = cur.r;
			int y = cur.c;
			if (cur.dist > dist[x][y])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (dist[nx][ny] > cur.dist + map[nx][ny]) {
					dist[nx][ny] = cur.dist + map[nx][ny];
					pq.add(new Status(nx, ny, dist[nx][ny]));
				}
			}
		}
		sb.append("Problem " + (tc++) + ": " + dist[N - 1][N - 1] + "\n");
	}
}