package DP;
import java.util.Scanner;

public class beakjoon9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int  k = 0; k < T; k++){
            int N = sc.nextInt();
            int[][] val = new int[N+1][2];
            int[][] DP = new int[N+1][2];
            for(int j = 0; j < 2; j++){
                for(int i = 1; i <=N;i++)
                {
                    val[i][j] = sc.nextInt();
                }   
            }

            DP[1][0]=val[1][0]; 
            DP[1][1]=val[1][1]; 
            for(int i = 2; i <=N;i++){
                DP[i][0] = Math.max( DP[i-1][1], DP[i-2][1]) + val[i][0];
                DP[i][1] = Math.max( DP[i-1][0], DP[i-2][0]) + val[i][1];
            }
            System.out.println(Math.max(DP[N][0], DP[N][1]));
            
            sc.close();
        }
    }
}
