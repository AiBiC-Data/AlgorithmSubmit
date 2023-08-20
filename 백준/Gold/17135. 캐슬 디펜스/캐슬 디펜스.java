import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] matrix;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        D = scanner.nextInt();
        matrix = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int answer = 0;
        List<int[]> archorPos = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    archorPos.add(new int[]{i, j, k});
                }
            }
        }
        
        for (int[] a : archorPos) {
            answer = Math.max(answer, kill(a));
        }

        System.out.println(answer);
    }

    static int kill(int[] archor) {
        int[][] tempMatrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, M);
        }

        int[][] killed = new int[N][M];
        int result = 0;

        for (int i = N - 1; i >= 0; i--) {
            List<int[]> thisTurn = new ArrayList<>();

            for (int ay : archor) {
                Deque<int[]> dq = new ArrayDeque<>();
                dq.add(new int[]{i, ay, 1});

                while (!dq.isEmpty()) {
                    int[] current = dq.poll();
                    int x = current[0];
                    int y = current[1];
                    int d = current[2];

                    if (tempMatrix[x][y] == 1) {
                        thisTurn.add(new int[]{x, y});
                        if (killed[x][y] == 0) {
                            killed[x][y] = 1;
                            result += 1;
                        }
                        break;
                    }

                    if (d < D) {
                        for (int di = 0; di < 3; di++) {
                            int nx = x + dx[di];
                            int ny = y + dy[di];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                                dq.add(new int[]{nx, ny, d + 1});
                            }
                        }
                    }
                }
            }

            for (int[] pos : thisTurn) {
                tempMatrix[pos[0]][pos[1]] = 0;
            }
        }

        return result;
    }
}