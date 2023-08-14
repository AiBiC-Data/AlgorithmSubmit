import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int cnt = 0;

        while (N > 1) {
            int size = (int) (Math.pow(2,N) / 2);
            
            if (r < size && c < size) {
            	
            } else if (r < size && c >= size) {
                cnt += size * size;
                c -= size;
            } else if (r >= size && c < size) {
                cnt += size * size * 2;
                r -= size;
            } else if (r >= size && c >= size) {
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