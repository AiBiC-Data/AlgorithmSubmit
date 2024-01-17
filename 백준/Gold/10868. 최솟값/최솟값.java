import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        tree = new int[n << 2];
        init(1, n, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = getMin(1, n, a, b, 1);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static int getMin(int start, int end, int left, int right, int node) {
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        } else if (left <= start && right >= end) {
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            int l = getMin(start, mid, left, right, node << 1);
            int r = getMin(mid + 1, end, left, right, (node << 1) + 1);
            return Math.min(l, r);
        }
    }

    private static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node << 1);
        init(mid + 1, end, (node << 1) + 1);
        tree[node] = Math.min(tree[node << 1], tree[(node << 1) + 1]);
        return;
    }
}