import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_구간합구하기_5604 {
	
	static int T;
	static long A, B, ans;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			ans = 0;
			long pos = 1;
			
			while (A <= B) {
				
				while (A % 10 != 0 && A <= B) {
					calc(A, pos);
					A++;
				}
				
				if (A > B || (A == 0 && B == 0)) break;
				
				while (B % 10 != 9 && A <= B) {
					calc(B, pos);
					B--;
				}
				
				A /= 10;
				B /= 10;
				if (A >= B || (A == 0 && B == 0)) break;
				long m = (B - A + 1) * pos; // m 은 4 가 됨
				
				for (int i = 1; i < 10; i++) ans += m * i;
				
				pos *= 10;
			}

			System.out.println("#" + t + " " + ans);
		}
		

	}

	static void calc(long n, long t) {
		while (n > 0) {
			ans += (n % 10) * t;
			n /= 10;
		}
	} 
}