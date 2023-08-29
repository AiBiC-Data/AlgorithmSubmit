import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] houses = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] color = new int[N][3];
		color[0][0] = houses[0][0];
		color[0][1] = houses[0][1];
		color[0][2] = houses[0][2];
		for (int i = 1; i < N; i++) {
			color[i][0] = Math.min(color[i - 1][1] + houses[i][0], color[i - 1][2] + houses[i][0]);
			color[i][1] = Math.min(color[i - 1][0] + houses[i][1], color[i - 1][2] + houses[i][1]);
			color[i][2] = Math.min(color[i - 1][0] + houses[i][2], color[i - 1][1] + houses[i][2]);
		}
		int ans = color[N - 1][0];
		ans = Math.min(ans, color[N - 1][1]);
		ans = Math.min(ans, color[N - 1][2]);
		System.out.println(ans);
	}
}