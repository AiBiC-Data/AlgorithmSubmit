import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, ans;
	static int alpha = 0;
	static char[][] map;
	static boolean[][] visit;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
			}
		}
		visit[0][0] = true;
		alpha |= 1 << (map[0][0] - 'A');
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			int tmp = map[nx][ny] - 'A';
			if (visit[nx][ny] || (alpha & 1 << tmp) != 0)
				continue;
			alpha |= 1 << tmp;
			visit[nx][ny] = true;
			dfs(nx, ny, cnt + 1);
			visit[nx][ny] = false;
			alpha &= ~(1<<tmp);
		}

	}

}