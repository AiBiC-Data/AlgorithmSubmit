import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n+2];
		
		arr[1] = 0;
		arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			if(i%2==0) a=arr[i/2];
			if(i%3==0) b=arr[i/3];
			arr[i] = Math.min(a, arr[i-1]);
			arr[i] = Math.min(arr[i],  b);
			arr[i] += 1;
		}
		
		System.out.println(arr[n]);

	}
}
# DP로 풀수 있다.
# 최솟값을 구하는데 6으로 나누어 떨어질때, 3으로 나누어 떨어질때, 2로 나누어 떨어질때, else로 나누고 +1을 하면 된다.
