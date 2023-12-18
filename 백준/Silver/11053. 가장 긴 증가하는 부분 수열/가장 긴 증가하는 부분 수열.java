import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] dp = new int[N];	# LIS 적용할 dp 배열
		int[] in = new int[N];
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;	# 각 처음 값 세팅
			for (int j = 0; j < i; j++) {	# 이전 값들을 하나씩 살펴보며
				if (in[j] < in[i] && dp[i] < dp[j] + 1) {	# 인풋 비교한 다음 그 인풋의 dp 비교 후 업데이트
					dp[i] = dp[j] + 1;
				}
			}
			if (max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
# 간단한 LIS 문제
# dp로 O(N^2)으로 풀 수 있다
# dp 값을 먼저 1로 세팅하고 이전 값들을 다시 하나씩 살펴보며 현재 값이 이전 값 보다 큰 경우 비교
