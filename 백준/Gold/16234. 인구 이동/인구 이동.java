import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Node> list;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(move());
    }
    
    public static int move() {
        int result = 0;
        while(true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); 
                        if(list.size() > 1) {
                            change(sum);
                            flag = true;
                        }    
                    }
                }
            }
            if(!flag) return result;;
            result++;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;
        
        int sum = map[x][y];
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    public static void change(int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
            map[n.x][n.y] = avg;
        }
    }
    
    public static class Node {
        int x; 
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

