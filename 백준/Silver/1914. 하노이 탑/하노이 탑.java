import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE);
		System.out.println(c);
		if(N<=20) {
			cnt=0;
			hanoi(N, 1,2,3);
			System.out.println(sb);
		}
	}
	static void hanoi(int dep, int st, int tmp, int end) {
		if(dep==1) {
			sb.append(st + " " + end + "\n");
			return;
		}
		hanoi(dep-1, st, end, tmp);
		sb.append(st + " " + end + "\n");
		hanoi(dep-1, tmp, st, end);
	}
	
}