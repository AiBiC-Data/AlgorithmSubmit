import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == 1) {
			int i = Integer.parseInt(br.readLine());
			if (K == i) {
				sb.append(0);
				System.out.println(sb.toString());
			} else {
				sb.append(1);
				System.out.println(sb.toString());
			}
		} else {
			int ans = 0;
			int[] dp = new int[N];
			dp[1] = 1;

			for (int i = 2; i < N; i++) {
				dp[i] = (2 * dp[i - 1] + 1) % MOD;
			}

			int[] panes = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				panes[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = N - 1; i > 0; i--) {
				// 1. 현재 위치면 0 2. 다른 위치면 하노이탑 n-1번째 옮기기
				if (K == panes[i])
					continue;
				ans = (ans + dp[i] + 1) % MOD;
				K = 6 - K - panes[i];
			}

			// 마지막 값 계산
			if (K == panes[0]) {
			} else {
				ans = (ans + 1) % MOD;
			}
			sb.append(ans);
			System.out.println(sb.toString());
		}
	}
}