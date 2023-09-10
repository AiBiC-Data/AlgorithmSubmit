import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static Queue<Integer> truth;
	static ArrayList[] people;
	static ArrayList[] party;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new ArrayList[N+1];
		party = new ArrayList[M+1];
		visited = new boolean[M+1];
		
		for (int i = 1; i < N+1; i++) {
			people[i] = new ArrayList<>();
		}
		for (int i = 1; i < M+1; i++) {
			party[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		truth = new ArrayDeque();
		
		for (int i = 0; i < K; i++) {
			truth.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			for (int j = 0; j < p; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				party[i].add(tmp);
				people[tmp].add(i);
			}
		}
		
		while(!truth.isEmpty()) {
			int person = truth.poll();
			int size = people[person].size();
			for(int i=0; i<size; i++) {
				int tmp = (int) people[person].get(i);
				if(!visited[tmp]) {
					for (int j = 0; j < party[tmp].size(); j++) {
						truth.add((Integer) party[tmp].get(j));
					}
					visited[tmp] = true;
				}
			}
		}
		int ans =0;
		for (int i = 1; i < M+1; i++) {
			if(!visited[i]) ans++;
		}
		sb.append(ans);
		System.out.println(sb);
	}
}