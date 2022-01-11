package DP;
import java.util.Scanner;

public class beakjoon4811 {
    public static void main(String[] args) {
        long[][] DP = new long[31][31];
        Scanner sc =new Scanner(System.in);


        DP[0][0] = 1;
        DP[1][0] = 1;
        DP[1][1] = 1;
        for(int i= 2; i <= 30; i++){
            DP[i][0] = 1;
            for(int j = 1; j <= i; j++){
                DP[i][j] = DP[i][j-1] + DP[i-1][j];
            }

        }

        while(true){
            int n = sc.nextInt();
            if(n == 0)break;
            System.out.println(DP[n][n]);
        }

        sc.close();
    }
}
