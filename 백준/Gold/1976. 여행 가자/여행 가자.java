import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Node {
    int end;
 
    public Node(int end) {
        this.end = end;
    }
}
public class Main {
    static int n, m;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
 
        list = new ArrayList[n + 1];
 
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
 
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if (s[j].charAt(0) == '1') {
                    list[i].add(new Node(j + 1));
                }
            }
        }
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < m - 1; i++) {
            boolean check = dij(Integer.parseInt(s[i]), Integer.parseInt(s[i + 1]));
            if (!check) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
 
    public static boolean dij(int start, int end) {
        if(start == end){
            return true;
        }
 
        boolean[] visit = new boolean[n + 1];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start));
 
 
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!visit[poll.end]) {
                visit[poll.end] = true;
                for (Node next : list[poll.end]) {
                    queue.add(next);
                    if (next.end == end) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}