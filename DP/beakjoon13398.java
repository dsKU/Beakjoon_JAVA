package DP;
import java.util.Scanner;

public class beakjoon13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] val = new int[N+1];
        int[][] DP = new int[N+1][2];
        for(int i = 0 ; i < N ; i++ ){
            val[i] = sc.nextInt();
        }
        int ans = DP[0][0] = DP[0][1] = val[0];

        for(int i = 1 ; i < N ; i++ ){
            DP[i][0] = DP[i][1] = val[i];
            DP[i][0] = Math.max(DP[i-1][0] + val[i], DP[i][0]);
            DP[i][1] = Math.max(DP[i-1][1] + val[i], DP[i-1][0]);  
        
            ans = Math.max(ans,Math.max(DP[i][0],DP[i][1]));
        }
        
        System.out.println(ans);
        sc.close();
    }
}
