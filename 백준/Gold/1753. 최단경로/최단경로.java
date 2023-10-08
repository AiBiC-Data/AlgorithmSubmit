import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, K;
	static List<Node>[] list;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			Node tmp = new Node(end, wei);
			list[from].add(tmp);
		}
		
		dijkstra(K);
		for (int i = 1; i < V+1; i++) {
			sb.append(dist[i]==INF?"INF\n":dist[i]+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k,0));
		dist[k]=0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;
			
			for(Node node: list[cur]) {
				if(dist[node.to]>dist[cur]+node.weight) {
					dist[node.to]=dist[cur]+node.weight;
					pq.add(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
}