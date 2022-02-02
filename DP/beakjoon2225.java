package DP;
import java.util.*;

public class beakjoon2225 {
    static int N,M;
    static long[][] DP;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        DP = new long [M+1][N+1];
        for(int i = 0; i <= N; i++)
            DP[1][i] = 1;
        
        for(int i = 2; i <= M; i++){
            for(int j = 0; j <= N; j++){
                for(int k = 0; k <= j; k++){
                    DP[i][j] += DP[i-1][j-k];
                    DP[i][j] %= 1_000_000_000;
                }
            }
        }
        
        System.out.println(DP[M][N]);
        sc.close();
    }
}
