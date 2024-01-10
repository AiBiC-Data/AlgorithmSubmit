import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String S, T;
	static int ans;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		int lenS = S.length();
		int lenT = T.length();
		
		while(lenS++<lenT) {
			StringBuffer sb  = new StringBuffer();
			if(T.endsWith("A")) T = T.substring(0,T.length()-1);
			else if(T.endsWith("B")) {
				T =T.substring(0, T.length()-1);
				T = sb.append(T).reverse().toString();
			}
		}
		ans = S.equals(T) ? 1 : 0;
		System.out.println(ans);
	}

}