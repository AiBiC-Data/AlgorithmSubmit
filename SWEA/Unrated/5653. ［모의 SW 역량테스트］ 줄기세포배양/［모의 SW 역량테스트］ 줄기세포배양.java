import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, k;
	static int[][][] map;
	static Queue<Cell> q = new LinkedList();
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Cell {
		int x, y, live, time, duration;

		public Cell(int x, int y, int live, int time, int duration) {
			super();
			this.x = x;
			this.y = y;
			this.live = live;
			this.time = time;
			this.duration = duration;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			q.clear();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n + 2 * k][m + 2 * k][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[k + i][k + j][0] = Integer.parseInt(st.nextToken());
					if (map[k + i][k + j][0] != 0)
						q.add(new Cell(i+k, j+k, -1, 0, map[k + i][k + j][0]));
				}
			}

			for (int i = 1; i <= k; i++) {
				bfs(i);
			}
			int ans =0;
			for (int i = 0, end = q.size(); i < end; i++) {
				Cell cell = q.poll();
				if(cell.duration == map[cell.x][cell.y][0]) ans++;
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int t) {
		for (int i = 0, end = q.size(); i < end; i++) {
			Cell cell = q.poll();
			int next_t = cell.time + 1;

			if (cell.duration != map[cell.x][cell.y][0])
				continue;

			if (cell.live == 1 && cell.time == 0) {
				for (int j = 0; j < 4; j++) {
					int nx = cell.x + dx[j];
					int ny = cell.y + dy[j];

					if (map[nx][ny][0] != 0) {
						if (map[nx][ny][1] < t)
							continue;
						else if (map[nx][ny][1] == t && map[nx][ny][0] < cell.duration) {
							map[nx][ny][0] = cell.duration;
							q.add(new Cell(nx, ny, -1, 0, cell.duration));
						}
					} else {
						map[nx][ny][0] = cell.duration;
						map[nx][ny][1] = t;
						q.add(new Cell(nx, ny, -1, 0, cell.duration));
					}
				}
			}
			if (next_t == cell.duration) {
				if (cell.live == 1)
					continue;
				q.add(new Cell(cell.x, cell.y, 1, 0, cell.duration));
			} else
				q.add(new Cell(cell.x, cell.y, cell.live, next_t, cell.duration));

		}
	}
}