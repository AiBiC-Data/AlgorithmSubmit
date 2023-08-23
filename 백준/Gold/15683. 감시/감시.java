import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static ArrayList<Camera> cameralist;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Camera {
		int x, y, num;

		public Camera(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];
		cameralist = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] != 0 && room[i][j] != 6) {
					cameralist.add(new Camera(i, j, room[i][j]));
				}
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0, room);
		System.out.println(ans);
	}

	static void dfs(int num, int[][] map) {
		if (num == cameralist.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}System.out.println();
			ans = Math.min(ans, cnt);
			return;
		}
		Camera camera = cameralist.get(num);
		int x = camera.x;
		int y = camera.y;
		int no = camera.num;
		int[][] newMap = new int[N][M];
		deepCopy(map, newMap);
		int nx,ny;
		switch (no) {
		case 1:
			for (int i = 0; i < 4; i++) {
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				
				dfs(num + 1, newMap);
				deepCopy(map, newMap);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i+2];
					ny += dy[i+2];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				dfs(num + 1, newMap);
				deepCopy(map, newMap);
			}
			break;
		
		case 3:
			for (int i = 0; i < 4; i++) {
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				nx = x;
				ny = y;
				while (true) {
					nx += dx[(i+1)%4];
					ny += dy[(i+1)%4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				
				dfs(num + 1, newMap);
				deepCopy(map, newMap);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				nx = x;
				ny = y;
				while (true) {
					nx += dx[(i+1)%4];
					ny += dy[(i+1)%4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				nx = x;
				ny = y;
				while (true) {
					nx += dx[(i+2)%4];
					ny += dy[(i+2)%4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
				dfs(num + 1, newMap);
				deepCopy(map, newMap);
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				nx = x;
				ny = y;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || newMap[nx][ny] == 6)
						break;
					if (newMap[nx][ny] == 0)
						newMap[nx][ny] = -1;
				}
			}

			dfs(num + 1, newMap);
			deepCopy(map, newMap);
			break;
		}
	}

	static void deepCopy(int[][] map1, int[][] map2) {
		for (int i = 0; i < N; i++) {
			map2[i] = Arrays.copyOf(map1[i], M);
		}
	}
}