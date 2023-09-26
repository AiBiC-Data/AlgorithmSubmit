import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int command = str.charAt(j);
				if (command == 'L')
					map[i][j] = 0;
				else if (command == 'R')
					map[i][j] = 1;
				else if (command == 'U')
					map[i][j] = 2;
				else if (command == 'D')
					map[i][j] = 3;
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		int nx = x + dx[map[x][y]];
		int ny = y + dy[map[x][y]];

		if (!visited[nx][ny]) {
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
		else 
			if(!check[nx][ny]) ans++;
		check[x][y]=true;
	}
}
