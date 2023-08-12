import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int comp = (1 << N) - 1;

			if ((M & comp) == comp)
				sb.append("ON \n");
			else
				sb.append("OFF \n");
		}
		System.out.println(sb);
	}

}