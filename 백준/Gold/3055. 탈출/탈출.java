import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<int[]> water;
	static ArrayDeque<int[]> hok;
	static int R, C;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static boolean fin;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		hok = new ArrayDeque<>();
		water = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if (str[j] == 'S') {
					hok.add(new int[] { i, j, 0 });
					map[i][j] = '.';
				} else if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}
			}
		}
		
		while (!fin) {
			if (hok.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			waterMove();
			bfs();
		}
		System.out.println(hok.pollLast()[2]);
	}

	static void bfs() {
		int size = hok.size();
		for (int ii = 0; ii < size; ii++) {
			int[] where = hok.poll();
			visited[where[0]][where[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = where[0] + dx[i];
				int ny = where[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny])
					continue;

				if (map[nx][ny] == 'D') {
					hok.add(new int[] { nx, ny, where[2] + 1 });
					fin = true;
					return;
				}
				if (map[nx][ny] == '.') {
					hok.add(new int[] { nx, ny, where[2] + 1 });
					visited[nx][ny] = true;
				}
			}
		}
	}

	static void waterMove() {
		int size = water.size();
		for (int i = 0; i < size; i++) {
			int[] tmp = water.poll();
			for (int j = 0; j < 4; ++j) {
				int nx = tmp[0] + dx[j];
				int ny = tmp[1] + dy[j];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}
				if (map[nx][ny] == '.') {
					map[nx][ny] = '*';
					water.offer(new int[] { nx, ny });
				}
			}
		}
	}
}