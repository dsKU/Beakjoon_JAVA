package DP;
import java.util.Scanner;

public class beakjoon1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        
        int[][] DP = new int[N+1][3];
        //0 : X 1 : O
        DP[1][0] = 1; DP[1][2]= 1; DP[1][1] = 1;
        for(int i = 2; i <= N; i++){
            DP[i][0] = (DP[i-1][1] + DP[i-1][2])%9901;
            DP[i][1] = (DP[i-1][0] + DP[i-1][2])%9901;
            DP[i][2] = (DP[i-1][1] + DP[i-1][2] + DP[i-1][0])%9901;
        }
        int ans = (DP[N][0]+DP[N][1]+DP[N][2])%9901;


        
        System.out.println(ans);
        sc.close();
    }
}
