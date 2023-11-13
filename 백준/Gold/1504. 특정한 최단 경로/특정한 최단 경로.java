import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, weight;

	Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

public class Main {
	static int N, E;
	static ArrayList<ArrayList<Node>> alist;
	static int[] dist;
	static boolean[] visited;
	static final int INF = 200000000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		alist = new ArrayList<>();
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			alist.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			alist.get(start).add(new Node(end, weight));
			alist.get(end).add(new Node(start, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int case1 = 0;
		case1 += dijkstra(1, v1);
		case1 += dijkstra(v1, v2);
		case1 += dijkstra(v2, N);

		int case2 = 0;
		case2 += dijkstra(1, v2);
		case2 += dijkstra(v2, v1);
		case2 += dijkstra(v1, N);

		int ans = (case1 >= INF && case2 >= INF) ? -1 : Math.min(case1, case2);
		sb.append(ans+"\n");
		System.out.println(sb.toString());
	}

	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			if (!check[cur]) {
				check[cur] = true;
				for (Node node : alist.get(cur)) {
					if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}
}