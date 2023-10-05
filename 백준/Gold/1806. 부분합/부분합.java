import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int ans = INF;
		int sum = 0;
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0, idx = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];

			if (sum >= S) {
				ans = Math.min(ans, i - idx + 1);
				while (sum >= S) {
					ans = Math.min(ans, i - idx + 1);
					sum -= nums[idx++];
				}
			}
			if(i==N-1) {
				
			}
		}
		if (ans == INF)
			System.out.println(0);
		else
			System.out.println(ans);
	}
}