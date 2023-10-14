import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static StringTokenizer st;
	static int[][] map;
	static Snake snake, tail;
	static Queue<Rotate> q;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Rotate {
		int x;
		char c;

		public Rotate(int x, char c) {
			super();
			this.x = x;
			this.c = c;
		}

	}

	static class Snake {
		int r, c, dir;
		Queue<Integer> que = new LinkedList<>();

		public Snake(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		public int getQue() {
			return que.poll();
		}

		public void setQue(int x) {
			this.que.add(x);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = 0;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
		}

		q = new LinkedList<>();
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			q.add(new Rotate(x, c));
		}
		snake = new Snake(0, 0, 0);
		tail = new Snake(0, 0, 0);
		map[0][0] = -1;

		move();
		System.out.println(ans);
	}

	private static void move() {

		while (!q.isEmpty()) {
			Rotate rot = q.poll();
			while (true) {
				snake.r += dx[snake.dir];
				snake.c += dy[snake.dir];
				ans++;
				if (snake.r < 0 || snake.c < 0 || snake.r >= N || snake.c >= N) {
					return;
				}
				if (map[snake.r][snake.c] == -1)
					return;
				snake.setQue(snake.dir);
				if (map[snake.r][snake.c] == 1) {
					map[snake.r][snake.c] = -1;
				} else {
					map[snake.r][snake.c] = -1;
					int w = snake.getQue();
					map[tail.r][tail.c] = 0;
					tail.r += dx[w];
					tail.c += dy[w];
				}
				if (ans == rot.x) {
					if (rot.c == 'L')
						snake.dir = (snake.dir - 1 + 4) % 4;
					else
						snake.dir = (snake.dir + 1 + 4) % 4;
					break;
				}

			}
		}
		while (true) {
			snake.r += dx[snake.dir];
			snake.c += dy[snake.dir];
			ans++;

			if (snake.r < 0 || snake.c < 0 || snake.r >= N || snake.c >= N)
				return;
			if (map[snake.r][snake.c] == -1)
				return;
			snake.setQue(snake.dir);
			if (map[snake.r][snake.c] == 1)
				continue;
			else {
				int w = snake.getQue();
				tail.r += dx[w];
				tail.c += dy[w];
				map[tail.r][tail.c] = 0;
			}

		}
	}
}