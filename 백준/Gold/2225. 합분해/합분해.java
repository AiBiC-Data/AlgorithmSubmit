import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] nums = new int[K+1][N+1];
		for (int k = 1; k < K+1; k++) {
			for (int n = 0; n < N+1; n++) {
				if(n==0) nums[k][n]=1;
				else {
					nums[k][n] = (nums[k-1][n]+nums[k][n-1])%1000000000;
				}
			}
		}
		System.out.println(nums[K][N]);
	}

}