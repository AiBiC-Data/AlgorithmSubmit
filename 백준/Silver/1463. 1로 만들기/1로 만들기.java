import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int dp(int v) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { v, 0 });
		int size = q.size();
		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				int[] tmp = q.poll();
				v = tmp[0];
				if (v == 1) {
					return tmp[1];
				}
				if (v % 3 == 0)
					q.offer(new int[] { v/3, tmp[1] + 1 });
				if (v % 2 == 0)
					q.offer(new int[] { v/2, tmp[1] + 1 });
				q.offer(new int[] { v-1, tmp[1] + 1 });
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = dp(N);
		System.out.println(cnt);
	}
}