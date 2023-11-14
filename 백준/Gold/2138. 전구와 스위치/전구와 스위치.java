import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] light, finish;
	static int N;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		light = new int[N];
		finish = new int[N];

		String str = br.readLine();
		for (int i = 0; i < N; i++)
			light[i] = str.charAt(i) - '0';

		str = br.readLine();
		for (int i = 0; i < N; i++)
			finish[i] = str.charAt(i) - '0';

		int[] tmp = Arrays.copyOf(light, N);

		if (tmp[0] == 0)
			tmp[0] = 1;
		else
			tmp[0] = 0;
        
		if (tmp[1] == 0)
			tmp[1] = 1;
		else
			tmp[1] = 0;

		int ans = turn(light, finish);
		int ans2 = turn(tmp, finish);
		if (ans2 != -1)
			ans2++;

		if (ans == -1)
			System.out.println(ans2);
		else if (ans2 == -1)
			System.out.println(ans);
		else
			System.out.println(Math.min(ans2, ans));
	}

	private static int turn(int[] a, int[] b) {
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			if (a[i] != b[i]) {
				cnt++;
				if (a[i] == 0)
					a[i] = 1;
				else
					a[i] = 0;
				if (a[i + 1] == 0)
					a[i + 1] = 1;
				else
					a[i + 1] = 0;
				if (i != N - 2)
					if (a[i + 2] == 0)
						a[i + 2] = 1;
					else
						a[i + 2] = 0;
			}
		}
		return a[N - 1] != b[N - 1] ? -1 : cnt;
	}
}