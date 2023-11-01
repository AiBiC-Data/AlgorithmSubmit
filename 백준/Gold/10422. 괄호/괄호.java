import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		long[] dp = new long[2501];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= 2500; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = (dp[i]+ dp[i - j] * dp[j - 1]) % 1000000007;
			}
		}
		for (int i = 0; i < T; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp % 2 == 1)
				sb.append(0 + "\n");
			else
				sb.append(dp[tmp / 2] + "\n");
		}
		System.out.println(sb.toString());
	}
}