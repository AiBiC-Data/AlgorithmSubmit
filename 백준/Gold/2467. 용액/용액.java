import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, nums[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		int min = left;
		int max = right;

		long comp = Integer.MAX_VALUE ;
		while (left < right) {
			long tmp = nums[left] + nums[right];
			if (comp > Math.abs(tmp)) {
				min = left;
				max = right;
				comp=Math.abs(tmp);
			}
			if(tmp>=0) {
				right--;
			}else {
				left++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(nums[min]+" "+nums[max]);
		System.out.println(sb.toString());
	}

}