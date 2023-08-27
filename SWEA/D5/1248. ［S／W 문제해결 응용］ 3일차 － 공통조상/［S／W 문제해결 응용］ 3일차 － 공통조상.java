import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import sun.util.locale.StringTokenIterator;

public class Solution {
	static int ans, N, M, A, B;
	static Node[] nodes; // node[i] := i 번 정점의 자식 정점들
	static ArrayList<Integer> ancestorA, ancestorB;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static public class Node {
		List<Integer> children;
		int parents;

		Node() {
			this.children = new ArrayList<>();
			this.parents = 0;
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			nodes = new Node[N + 1];
			ancestorA = new ArrayList<>();
			ancestorB = new ArrayList<>();

			for (int i = 0; i < N + 1; i++) {
				nodes[i] = new Node();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes[p].children.add(c);
				nodes[c].parents = p;
			}

			// A 와 B 의 조상 찾기
			traverse(A, ancestorA);
			traverse(B, ancestorB);

			for (int i = 0; i < N; i++) {
				if (!ancestorA.get(i).equals(ancestorB.get(i)))
					break;
				ans = ancestorA.get(i);
			}

			System.out.printf("#%d %d %d\n", t, ans, dfs(ans));
		}
	}

	public static int dfs(int idx) { // idx 를 root로 갖는 subtree 의 크기를 계산하는 함수
		int res = 1;
		for (int child : nodes[idx].children) {
			res += dfs(child);
		}
		return res;
	}

	public static void traverse(int idx, ArrayList<Integer> ancestor) {
		int parent = nodes[idx].parents;
		if (parent != 0) { // 부모 노드가 존재한다면
			traverse(parent, ancestor); // 조상을 더 찾으라고 재귀 호출 수행
		}
		ancestor.add(idx);
	}

	
}