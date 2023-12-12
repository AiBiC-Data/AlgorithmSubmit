import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[][] map = new int[5][5];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}

		cnt = 0;
		while (true) {
			int num = q.poll();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == num) {
						map[i][j] = -1;
						break;
					}
				}
			}
			check();

			if (cnt >= 3)
				break;
			cnt = 0;
		}
		System.out.println(25 - q.size());
	}

	private static void check() {
		int c = 0;
		for (int i = 0; i < 5; i++) {
			c = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == -1)
					c++;
			}
			if (c == 5)
				cnt++;
		}
		for (int i = 0; i < 5; i++) {
			c = 0;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == -1)
					c++;
			}
			if (c == 5)
				cnt++;
		}
		c = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == -1)
				c++;
		}
		if (c == 5)
			cnt++;
		c = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] == -1)
				c++;
		}
		if (c == 5)
			cnt++;
	}
}