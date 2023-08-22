import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static ArrayList<int[]> list;
    static int n, m, k;
    static boolean[] check;
    static Deque<int[]> q = new LinkedList<>();
    static int min_ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int s = scanner.nextInt();
            list.add(new int[]{r - 1, c - 1, s});
        }

        check = new boolean[k];
        perm(0);
        System.out.println(min_ans);
    }

    static void perm(int cnt) {
        if (cnt == k) {
            Deque<int[]> que = new LinkedList<>(q);
            min_ans = Math.min(min_ans, rotate(que));
            return;
        }

        for (int i = 0; i < k; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            q.add(list.get(i));
            perm(cnt + 1);
            check[i] = false;
            q.pollLast();
        }
    }

    static int rotate(Deque<int[]> q) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(arr[i], m);
        }

        while (!q.isEmpty()) {
            int[] line = q.poll();
            int x = line[0];
            int y = line[1];
            int z = line[2];
            int lx = x - z;
            int ly = y - z;
            int rx = x + z;
            int ry = y + z;

            while (lx < rx && ly < ry) {
                int dir = 0;
                int before = tmp[lx][ly];
                int curr_x = lx;
                int curr_y = ly;

                while (true) {
                    int nx = curr_x + dx[dir];
                    int ny = curr_y + dy[dir];
                    
                    if (!(lx <= nx && nx <= rx) || !(ly <= ny && ny <= ry)) {
                        dir++;
                        continue;
                    }
                    
                    int temp = tmp[nx][ny];
                    tmp[nx][ny] = before;
                    before = temp;
                    curr_x = nx;
                    curr_y = ny;
                    
                    if (curr_x == lx && curr_y == ly) {
                        lx++;
                        ly++;
                        rx--;
                        ry--;
                        break;
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int[] row : tmp) {
            int sum = 0;
            for (int value : row) {
                sum += value;
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}