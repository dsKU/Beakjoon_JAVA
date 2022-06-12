import java.io.*;
import java.util.*;

public class swea5607 {
    static int MOD = 1234567891;
    static long solve(long n, int a){
        if(a == 0) return 1;
        long temp = solve(n, a/2);
        if(a%2 ==0){
            return (temp * temp) % MOD;
        }
        else{
            return ((temp * n) % MOD * temp) % MOD;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long arr[] = new long[1000000+1];
        arr[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            arr[i] = (arr[i-1] * i) % MOD;
        }

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long bottom = (arr[N-R] * arr[R]) % MOD;


            long ans = (solve(bottom, MOD-2) * arr[N]) % MOD;
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
