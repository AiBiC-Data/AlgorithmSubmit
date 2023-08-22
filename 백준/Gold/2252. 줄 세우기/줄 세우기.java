import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static Node[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new Node[N + 1];
		inDegree = new int[N + 1];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A] = new Node(B, adjList[A]);
			++inDegree[B];
		}
		ArrayList<Integer> orderList = topologySort();
		StringBuilder sb = new StringBuilder();
		for (int o : orderList) {
			sb.append(o).append(" ");
		}
		System.out.println(sb);

	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; ++i) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			orderList.add(cur);

			for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
				if (--inDegree[tmp.vertex] == 0)
					queue.offer(tmp.vertex);
			}
		}
		return orderList;
	}

}