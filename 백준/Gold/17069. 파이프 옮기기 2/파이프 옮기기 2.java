import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		long[][][] pipe = new long[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pipe[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; ++j) {
				if (map[i][j] == 1)
					continue;
				pipe[i][j][0] = pipe[i][j - 1][0] + pipe[i][j - 1][2];
				if(i == 0) 
					continue;
				pipe[i][j][1] = pipe[i - 1][j][1] + pipe[i - 1][j][2];
				if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
					continue;
				pipe[i][j][2] = pipe[i - 1][j - 1][0] + pipe[i - 1][j - 1][1] + pipe[i - 1][j - 1][2];
			}
		}
		System.out.println(pipe[N - 1][N - 1][0] + pipe[N - 1][N - 1][1] + pipe[N - 1][N - 1][2]);
	}
}