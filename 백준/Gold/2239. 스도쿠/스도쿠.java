import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		dfs(0);
	}

	private static void dfs(int dep) {
		if (dep == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		int x = dep / 9;
		int y = dep % 9;

		if (map[x][y] != 0) {
			dfs(dep + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				boolean flag = true;
				for (int j = 0; j < 9; j++) {
					if (map[x][j] == i || map[j][y] == i) {
						flag = false;
						break;
					}
					int sqr_x = (x / 3) * 3;
					int sqr_y = (y / 3) * 3;
					for (int k = sqr_x; k < sqr_x + 3; k++) {
						for (int l = sqr_y; l < sqr_y + 3; l++) {
							if (map[k][l] == i) {
								flag = false;
								break;
							}
						}
					}
				}
				if (flag) {
					map[x][y] = i;
					dfs(dep + 1);
					map[x][y] = 0;
				}

			}
		}
	}

}