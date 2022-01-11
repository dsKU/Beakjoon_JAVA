package DP;
import java.util.Scanner;


public class beakjoon1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] DP = new int[N+1][];
        int ans = 0;
        
        for(int i = 0; i <= N; i++){
            DP[i] = new int[i+1];
            for(int j = 0; j < i; j ++){
                DP[i][j] = sc.nextInt();
                if(j == 0){
                    DP[i][j] += DP[i-1][j];
                }
                else if ( j == i - 1){
                    DP[i][j] += DP[i-1][j - 1];
                }
                else{
                    DP[i][j] += Math.max(DP[i-1][j],DP[i-1][j-1]);
                }
            }
        }
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, DP[N-1][i]);
        }
        System.out.println(ans);
        sc.close();
    }
}
