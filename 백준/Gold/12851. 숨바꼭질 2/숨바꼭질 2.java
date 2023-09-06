import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
			System.exit(0);
		}
		boolean flag = false;
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		int M = 100000;
		q.add(N);
		boolean[] visited = new boolean[M+1];
		visited[N] = true;
		while (!q.isEmpty()) {
			ans++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int tmp = q.poll();
				if (tmp-1 == K || tmp+1 ==K || tmp*2==K) {
//				if(tmp==K) {
					flag = true;
					cnt += 1;
					continue;
				}
				if (tmp - 1 >= 0 && !visited[tmp - 1]) {
//					visited[tmp - 1] = true;
					q.add(tmp - 1);
				}
				if (tmp + 1 <= M && !visited[tmp + 1]) {
//					visited[tmp + 1] = true;
					q.add(tmp + 1);
				}
				if (2 * tmp <= M && !visited[2 * tmp]) {
//					visited[2 * tmp] = true;
					q.add(2 * tmp);
				}
			}
			size = q.size();
			for (int i = 0; i < size; i++) {
				int tmp = q.poll();
				visited[tmp] = true;
				q.add(tmp);
			}
			if (flag) {
				break;
			}
//			ans++;
		}
		System.out.println(ans);
		System.out.println(cnt);
	}
}