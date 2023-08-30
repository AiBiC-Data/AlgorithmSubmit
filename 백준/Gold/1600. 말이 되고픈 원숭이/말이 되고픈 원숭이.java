import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1, };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = -1;
		bfs(0, 0, 0);
		System.out.println(ans);
	}

	static void bfs(int x, int y, int k) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < K + 1; i++) {
			visited[x][y][i] = true;
		}
		q.offer(new int[] { x, y, k });
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				if (now[0] == H - 1 && now[1] == W - 1) {
					ans=0;
					return;
				}
				for (int j = 0; j < 12; j++) {
					if (j == 4 && now[2] == K)
						break;
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];
					if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1) {
						if (cnt == 0)
							ans = -1;
						continue;
					}
					if (j < 4 && visited[nx][ny][now[2]])
						continue;
					if (j >= 4 && visited[nx][ny][now[2] + 1])
						continue;
					if (nx == H - 1 && ny == W - 1) {
						ans = cnt;
						return;
					}
					if (j < 4) {
						visited[nx][ny][now[2]] = true;
						q.offer(new int[] { nx, ny, now[2] });
					} else {
						visited[nx][ny][now[2] + 1] = true;
						q.offer(new int[] { nx, ny, now[2] + 1 });
					}
				}
			}
		}
	}
}