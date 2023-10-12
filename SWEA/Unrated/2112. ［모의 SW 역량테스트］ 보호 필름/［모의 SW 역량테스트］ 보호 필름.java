import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, K;
	static int D, W;
	static int[][] map, tmp;
	static final int INF = Integer.MAX_VALUE;
	static int max;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[14][21];
			tmp = new int[14][21];
			max = INF;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					tmp[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (!check()) {
				for (int i = 1; i < K + 1; i++) {
					dfs(0, 0, i);
				}
			} else {
				max = 0;
			}
			if (max == INF)
				max = 0;
			System.out.println("#" + tc + " " + max);
		}
	}

	public static void dfs(int dep, int num, int k) {
		if (dep == D) {
			if (check()) {
				max = Math.min(num, max);
			}
			return;
		}
		if (num > k)
			return;
		if (max <= num)
			return;

		dfs(dep + 1, num, k);

		for (int i = 0; i < W; i++)
			map[dep][i] = 0;
		dfs(dep + 1, num + 1, k);

		for (int i = 0; i < W; i++)
			map[dep][i] = 1;
		dfs(dep + 1, num + 1, k);

		map[dep] = Arrays.copyOf(tmp[dep], W);

	}

	public static boolean check() {
		for (int i = 0; i < W; i++) {
			int a = 0, b = 0;
			boolean check = false;
			if (map[0][i] == 0)
				a++;
			else
				b++;
			for (int j = 1; j < D; j++) {
				if (map[j][i] == 0) {
					a++;
					if (b > 0)
						b = 0;
				} else {
					b++;
					if (a > 0)
						a = 0;

				}
				if (a >= K || b >= K) {
					check = true;
					break;
				}
			}
			if (!check)
				return false;
		}
		return true;
	}
}