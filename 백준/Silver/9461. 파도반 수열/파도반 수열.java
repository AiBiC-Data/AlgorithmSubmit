import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i < 101; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}

}