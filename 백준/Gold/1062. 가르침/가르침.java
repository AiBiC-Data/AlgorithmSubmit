import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count, N, K;
	static int[] words;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				int t = (int) word.charAt(j) - 97;
				words[i] |= 1 << t;
			}
		}
		if (K < 5) {
			System.out.println(0);
			return;
		}
		int bi = 0;
		bi = bi | 1 << (int) 'a' - 97;
		bi = bi | 1 << (int) 'n' - 97;
		bi = bi | 1 << (int) 't' - 97;
		bi = bi | 1 << (int) 'i' - 97;
		bi = bi | 1 << (int) 'c' - 97;
		comb(0, 0, bi);
		System.out.println(count);
	}

	private static void comb(int cnt, int st, int bi) {
		if (cnt == K - 5) {
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				if ((~bi & words[i]) == 0)
					tmp++;
			}
			count = Math.max(count, tmp);
			return;
		}

		for (int i = st; i < 26; i++) {
			if (bi == (bi | 1 << i))
				continue; // 중복 문자는 연산x
			comb(cnt + 1, i + 1, bi | 1 << i);
		}
	}

}