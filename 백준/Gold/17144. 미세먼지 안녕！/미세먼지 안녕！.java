import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] map, tmp;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int circular = 0;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == -1) {
					circular = r;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			tmp = new int[R][C];

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {

					if (map[r][c] != 0) {
						int dust = map[r][c] / 5;
						int dir = 4;

						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							if (nr < 0 || nc < 0 || nr >= R || nc >= C || ((nr == circular)&&nc==0) || ((nr == (circular - 1))&&nc==0)) {
								dir--;
								continue;
							}
							tmp[nr][nc] += dust;
						}

						tmp[r][c] += map[r][c] - dust * dir;
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				map[i] = Arrays.copyOf(tmp[i], C);
			}
			
			map[circular-1][0] = 0;
			map[circular][0] = 0;
			
			// 위 공기청정기-반시계
			for (int i = circular-2; i >0; i--) {
				map[i][0] = map[i-1][0];
			}
			for (int i = 0; i < C-1; i++) {
				map[0][i] = map[0][i+1];
			}
			for(int i=0; i<circular-1;i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			for (int i = C-1; i > 0; i--) {
				map[circular-1][i] = map[circular-1][i-1];
			}
			
			// 아래 공기청정기-시계
			for (int i = circular+1; i <R-1; i++) {
				map[i][0] = map[i+1][0];
			}
			for (int i = 0; i < C-1; i++) {
				map[R-1][i] = map[R-1][i+1];
			}
			for(int i=R-1; i>circular;i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			for (int i = C-1; i > 0; i--) {
				map[circular][i] = map[circular][i-1];
			}
			
		}
		int ans =0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans+=map[i][j];
			}
		}
		sb.append(ans);
		System.out.println(sb.toString());
	}

}