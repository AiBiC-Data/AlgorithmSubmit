import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans, C, R;
	static char[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j];
			}
		}
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		System.out.println(ans);
	}

	private static void dfs(int i, int j) {
		map[i][j] = 'X';
		if (j == C - 1) {
			flag= true;
			ans++;
			return;
		}
		if (i - 1 >= 0 && map[i - 1][j + 1] == '.')
			dfs(i - 1, j + 1); 
		if (!flag && map[i][j + 1] == '.')
			dfs(i, j + 1);
		if (!flag && i + 1 < R && map[i + 1][j + 1] == '.')
			dfs(i + 1, j + 1);
	}
}
