package DP;
import java.util.Scanner;

public class beakjoon11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] DP = new int [1001][10];
        DP[1][0] = 1;DP[1][4] = 1;DP[1][7] = 1;
        DP[1][1] = 1;DP[1][5] = 1;DP[1][8] = 1;
        DP[1][2] = 1;DP[1][6] = 1;DP[1][9] = 1;
        DP[1][3] = 1;
        int ans = 0;
        for(int i = 2; i < 1001;i++){
            for(int j = 0 ; j <= 9 ; j++){
                for(int k = j ; k <= 9 ; k++){
                    DP[i][j] = (DP[i][j] + DP[i-1][k]) % 10007;
                }
            }
        }
        for(int k = 0 ; k <= 9 ; k++){
            ans = (ans+DP[N][k])% 10007;
        }
        System.out.println(ans);sc.close();
    }
}
