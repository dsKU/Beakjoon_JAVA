import java.io.*;
import java.util.*;

public class beakjoon1328 {
    static int N,L,R;
    static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        long DP[][][] = new long[N + 1][N + 1][N + 1];

        DP[1][1][1] = 1;
        for(int i = 2; i <= N; i++){
            DP[i][i][1] = 1;
            DP[i][1][i] = 1;
        }
        for(int n=2; n<=N; n++) {
            for(int l=1; l<=L; l++) {
                for(int r=1; r<=R ; r++) {
                    DP[n][l][r] = DP[n - 1][l][r] * (n - 2) + DP[n - 1][l - 1][r] + DP[n - 1][l][r-1];
                    DP[n][l][r] %= MOD;
                    
                }
            }
        }
        

        System.out.println(DP[N][L][R]);
    }
}
