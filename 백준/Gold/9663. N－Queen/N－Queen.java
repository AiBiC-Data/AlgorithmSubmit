import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		dfs(0);
		System.out.println(cnt);
	}
	static void dfs(int dep) {
		if(dep ==N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			map[dep] = i;
			if(can(dep)) {
				dfs(dep+1);
			}
		}
	}
	static boolean can(int c) {
		for (int i = 0; i < c; i++) {
			if(map[c]==map[i]) {
				return false;
			}
			else if(Math.abs(c-i)==Math.abs(map[c]-map[i])) {
				return false;
			}
		}
		return true;
	}
}