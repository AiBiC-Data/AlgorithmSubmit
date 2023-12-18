import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int cnt = 0;

        while (N > 1) {
            int size = (int) (Math.pow(2,N) / 2);    # 처음 분할할 갯수
            
            if (r < size && c < size) {  # 2사분면
            	
            } else if (r < size && c >= size) {  # 1사분면
                cnt += size * size;
                c -= size;
            } else if (r >= size && c < size) {  # 4사분면
                cnt += size * size * 2;
                r -= size;
            } else if (r >= size && c >= size) {  # 3사분면
                cnt += size * size * 3;
                r -= size;
                c -= size;
            }
            N--;
        }

        if (r == 0 && c == 0) {
            System.out.println(cnt);
        } else if (r == 0 && c == 1) {
            System.out.println(cnt + 1);
        } else if (r == 1 && c == 0) {
            System.out.println(cnt + 2);
        } else if (r == 1 && c == 1) {
            System.out.println(cnt + 3);
        }
    }
}

# 분할정복은 while문으로 컨트롤 할거다.
# 먼저 size 설정이 필요하다.
# 그 다음 조건을 생각하며 분할을 시킨다.
# 조건을 빠져 나오고 나서도 조건문을 통해 답을 구하는 경우도 있다.
