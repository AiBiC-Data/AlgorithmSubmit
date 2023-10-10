import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);

			if (Math.abs(x - y) % 2 != 0)
				sb.append("#" + tc + " " + (Math.max(x, y) * 2 - 1)+"\n");
			else
				sb.append("#" + tc + " " + (Math.max(x, y) * 2)+"\n");
		}
		System.out.println(sb);
	}
}