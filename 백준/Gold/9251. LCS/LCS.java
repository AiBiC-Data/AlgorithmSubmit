import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int str1_len = str1.length;
		int str2_len = str2.length;
		
		int[][] dp = new int[str1_len + 1][str2_len + 1];
		
		for(int i = 1; i <= str1_len; i++) {
			for(int j = 1; j <= str2_len; j++) {
				
				if(str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}
				
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[str1_len][str2_len]);
	}
}