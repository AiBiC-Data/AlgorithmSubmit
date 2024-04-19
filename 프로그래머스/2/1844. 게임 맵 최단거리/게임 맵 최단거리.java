import java.util.*;

class Solution {
    
    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static boolean[][] visited;
    
    static int[] dx = { 0, 0, -1 ,1 };
    static int[] dy = { -1, 1, 0 , 0 };
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(0,0, maps);
        if(ans == Integer.MAX_VALUE) ans =-1;
        return ans;
    }
    
    static void bfs(int x, int y, int[][] maps){
        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(x,y,0));
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Node node = q.pop();
            if(node.x == n-1 && node.y == m-1){
                ans = node.s+1;
                return;
            }
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx<0 || ny <0 || nx>=n || ny >=m || maps[nx][ny]==0 || visited[nx][ny]) continue;
                q.add(new Node(nx, ny, node.s+1));
                
                visited[nx][ny] = true;
                
            }
        }
    }
    
    
}

class Node{
        int x,y,s;
        
        Node(int x, int y, int s){
            this.x= x;
            this.y = y;
            this.s = s;
        }
    }