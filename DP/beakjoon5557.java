package DP;
import java.util.Scanner;

public class beakjoon5557 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[N+1];
        long[][] DP = new long[N+1][21];
        for(int i = 1; i <= N ; i ++){
            val[i] = sc.nextInt();
        }

        DP[1][val[1]]++;
        for(int i = 2; i < N ; i ++){
            for(int j = 0; j <= 20 ; j ++){
                if(DP[i-1][j] == 0)continue;
                int plus = j + val[i];
                if(plus <=20){
                    DP[i][plus] += DP[i-1][j];
                }
                int minus = j - val[i];
                if(minus >= 0){
                    DP[i][minus] += DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N-1][val[N]]);
        sc.close();
    }
    
    
}
