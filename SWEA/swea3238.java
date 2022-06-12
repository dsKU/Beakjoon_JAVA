import java.io.*;
import java.util.*;

public class swea3238 {
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
        long arr[] = new long[100000+1];
        arr[0] = 1;
        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            MOD = Integer.parseInt(st.nextToken());

            for (int i = 1; i < MOD; i++) {
                arr[i] = (arr[i-1] * i) % MOD;
            }

            long ans = 1;
            while(N > 0 || R > 0){
                long a = N % MOD;
                long b = R % MOD;

                if(a < b) ans = 0;
                if(ans == 0) break;
                long top = arr[(int)a];
                long bottom = (arr[(int)(a-b)] * arr[(int)b]) % MOD;

                ans = (ans * top) % MOD;
                ans = ((solve(bottom, MOD - 2) % MOD) * ans ) % MOD;

                N /= MOD;
                R /= MOD;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
