import java.util.Arrays;
import java.util.Scanner;

public class beakjoon1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[N+1];
        int[][]DP = new int[N+1][2];
        val[0] = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N; i++){
            val[i] = sc.nextInt();
        }
        
        Arrays.sort(val);
        
        DP[1][0] = val[1];
        DP[1][1] = val[1];

        
        for(int i = 2; i <= N; i++){
            DP[i][0] = Math.max( DP[i-1][0], DP[i-1][1] ) + val[i];
            DP[i][1] = val[i] * val[i-1] + Math.max(DP[i-2][0], DP[i-2][1]);
        
        }
        System.out.println(Math.max(DP[N][0], DP[N][1]));
        sc.close();
    }    
}
