import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static FireBall[][] map;
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class FireBall {
        int r, c, m, s, d, cnt;
        boolean d_flag;

        public FireBall(int r, int c, int m, int s, int d, int cnt, boolean d_flag) {
            super();
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.cnt = cnt; // 합쳐진 파이어볼 개수
            this.d_flag = d_flag; // cnt>1일때 사용할거/ 방향 합이 짝수면 false
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<FireBall> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            FireBall fireball = new FireBall(r, c, m, s, d, 1, true);
            q.add(fireball);
        }

        while (K-- > 0) {
            int size = q.size();
            map = new FireBall[N][N];
            while (size-- > 0) {
                FireBall fireball = q.poll();
                int nr = (fireball.r + dr[fireball.d] * fireball.s + N * fireball.s) % N;
                int nc = (fireball.c + dc[fireball.d] * fireball.s + N * fireball.s) % N;
                FireBall newFireBall = new FireBall(nr, nc, fireball.m, fireball.s, fireball.d, 1, true);
                if (map[nr][nc] == null)
                    map[nr][nc] = newFireBall;
                else {
                    FireBall tmp = map[nr][nc];
                    tmp.m += newFireBall.m;
                    tmp.s += newFireBall.s;
                    tmp.cnt++;
                    if (tmp.d_flag && ((newFireBall.d) % 2 != (tmp.d) % 2))
                        tmp.d_flag = false;
//                    map[nr][nc] = tmp;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != null) {
                        FireBall target = map[i][j];
                        if (target.cnt == 1) {
                            q.add(target);
                        } else {
                            int cm = target.m / 5;
                            int cs = target.s / target.cnt;
                            if (cm == 0)
                                continue;
                            if (target.d_flag) {
                                for (int k = 0; k < 4; k++) {
                                    FireBall qIn = new FireBall(target.r, target.c, cm, cs, 2 * k, 1, true);
                                    q.add(qIn);
                                }
                            } else {
                                for (int k = 0; k < 4; k++) {
                                    FireBall qIn = new FireBall(target.r, target.c, cm, cs, 2 * k + 1, 1, true);
                                    q.add(qIn);
                                }
                            }
                            map[i][j] = null;
                        }
                    }
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            FireBall ansBall = q.poll();
//            System.out.println(ansBall.r+" "+ansBall.c);
            ans += ansBall.m;
        }
        System.out.println(ans);
    }

}