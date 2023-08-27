import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parents;
	static Node[] nodeList;

	static class Node implements Comparable<Node> {
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static void make() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = i;
		}
	}

	static int find(int v) {
		if (v == parents[v])
			return v;
		return parents[v] = find(parents[v]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodeList = new Node[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			nodeList[i] = new Node(start, end, distance);
		}

		Arrays.sort(nodeList);
		make();

		int ans = 0;
		int cnt = 0;
		for (Node node : nodeList) {
			if (union(node.from, node.to)) {
				ans += node.weight;
				if (++cnt == V - 1)
					break;
			}

		}
		System.out.println(ans);
	}
}