package DP;
import java.util.Arrays;
import java.util.Scanner;

public class beakjoon2629 {
    static int N;
    static int[] val;
    static boolean[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        val = new int[N+1];
        DP = new boolean[N+1][40001];
        int sum = 0;
        DP[0][0] = true;

        for(int i = 1 ; i <= N ; i ++){
            Arrays.fill(DP[i], false);
            val[i] = sc.nextInt();
            DP[i][0] = true;
            sum += val[i];
            for(int j = 1; j <= sum; j++){
                DP[i][j] = DP[i-1][j] || DP[i-1][Math.abs(j - val[i])] || DP[i-1][ j + val[i]] ;
            }
        }
        
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            if(DP[N][n]){
                System.out.print("Y ");
            }
            else{
                System.out.print("N ");
            }
        }
        sc.close();
    }
}
