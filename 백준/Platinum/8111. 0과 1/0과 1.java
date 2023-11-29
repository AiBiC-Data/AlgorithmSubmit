import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int MAX = 20000;
	static boolean[] visited;
	static int[] parent;
	static HashMap<Integer, Character> map;
	static int T, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
        
		for(int i = 0 ; i < T ; ++i) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			visited = new boolean[MAX];
			parent = new int[MAX];	
            
			bfs();
			print(0);
			System.out.println();
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parent[1] = -1;
		visited[1] = true;
		map.put(1, '1');
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int[] next = {(cur * 10) % N, (cur * 10 + 1) % N};
            
			for(int i = 0 ; i < 2 ; ++i) {
				if(visited[next[i]]) continue;
				map.put(next[i], (char)(i + '0'));
				parent[next[i]] = cur;
				if(next[i] == 0) return;
				
				visited[next[i]] = true;
				q.offer(next[i]);
			}
		}
	}
	
	private static void print(int idx) {
		if(idx == -1) {
			return;
		}
		print(parent[idx]);
		System.out.print(map.get(idx));
	}
}