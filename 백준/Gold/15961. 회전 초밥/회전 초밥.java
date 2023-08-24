import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c, ans;
	static int[] dishes, cnt;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dishes = new int[N+k];
		cnt = new int[d + 1];
		for (int i = 0; i < N; ++i) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			dishes[N+i] = dishes[i];
		}
		for (int i = 0; i < k; i++) {
			set.add(dishes[i]);
			cnt[dishes[i]] += 1;
		}
		int size = set.size();
		for (int i = 0; i < N ; i++) {
			if(cnt[c]==0) {
				size++;
			}
			ans = Math.max(ans, size);
			if (cnt[dishes[i]] == 1) {
				set.remove(dishes[i]);
				cnt[dishes[i]]-=1;
			}
			else {
				cnt[dishes[i]]-=1;
			}
			int next = dishes[i + k];
			set.add(next);
			cnt[next]+=1;
			size = set.size();
			ans = Math.max(ans, size);
		}
		if(cnt[c]==0) {
			size++;
		}
		ans = Math.max(ans, size);
		System.out.println(ans);
	}
}