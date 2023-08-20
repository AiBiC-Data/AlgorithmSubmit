import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D;
	static int[][] arr;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		List<int[]> where = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					where.add(new int[] { i, j, k });
				}
			}
		}

		for (int[] arc : where) {
			ans = Math.max(ans, kill(arc));
		}

		System.out.println(ans);
	}

	static int kill(int[] archor) {
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(arr[i], M);
		}

		int[][] killed = new int[N][M];
		int result = 0;

		for (int i = N - 1; i >= 0; i--) {
			List<int[]> thisTurn = new ArrayList<>();

			for (int arc : archor) {
				Deque<int[]> q = new ArrayDeque<>();
				q.add(new int[] { i, arc, 1 });

				while (!q.isEmpty()) {
					int[] current = q.poll();
					int x = current[0];
					int y = current[1];
					int d = current[2];

					if (map[x][y] == 1) {
						thisTurn.add(new int[] { x, y });
						if (killed[x][y] == 0) {
							killed[x][y] = 1;
							result += 1;
						}
						break;
					}

					if (d < D) {
						for (int di = 0; di < 3; di++) {
							int nx = x + dx[di];
							int ny = y + dy[di];
							if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
								q.add(new int[] { nx, ny, d + 1 });
							}
						}
					}
				}
			}

			for (int[] t : thisTurn) {
				map[t[0]][t[1]] = 0;
			}
		}
		return result;
	}
}