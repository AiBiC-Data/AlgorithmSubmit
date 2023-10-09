import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static final int MAX = Integer.MAX_VALUE >> 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(map[i], MAX);
			map[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (map[s][e] > c)
				map[s][e] = c;
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				if (i == k)
					continue;
				for (int j = 1; j < N + 1; j++) {
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == MAX)
					map[i][j] = 0;
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}