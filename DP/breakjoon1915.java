package DP;
import java.util.Scanner;

public class breakjoon1915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] DP = new int[N+1][M+1]; 
        int ans = 0;
        for(int i = 1; i <= N ; i ++){
            String str = sc.next();
            for(int j = 1; j <= M ; j ++){                
                int temp = str.charAt(j - 1) - 48;
                DP[i][j] =temp;
                if(temp == 1 && DP[i-1][j-1] > 0 && DP[i-1][j] > 0 && DP[i][j-1] > 0)
                    DP[i][j] = Math.min(DP[i-1][j], Math.min(DP[i][j-1], DP[i-1][j-1])) + temp;
                ans = Math.max(ans, DP[i][j]);
            }
        }

        System.out.println(ans*ans);
        sc.close();
    }
}
