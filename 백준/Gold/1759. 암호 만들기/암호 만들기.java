import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int L, C;
	static char[] alpha, tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		tmp = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		comb(0, 0, 0, 0);

	}

	static void comb(int dep, int flag, int aeiou, int remain) {
		if (dep == L) {
			if (aeiou >= 1 && remain>=2) {
				for (int i = 0; i < L; i++) {
					System.out.print(tmp[i]);
				}
				System.out.println();
			}
			return;
		}
		for (int i = flag; i < C; i++) {
			tmp[dep] = alpha[i];
			if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')
				comb(dep + 1, i + 1, aeiou+1, remain);
			else
				comb(dep + 1, i + 1, aeiou, remain+1);

		}
	}
}