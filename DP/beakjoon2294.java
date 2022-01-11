package DP;
import java.util.Arrays;
import java.util.Scanner;


public class beakjoon2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] val = new int[N+1];
        int[] DP = new int[M+1];
        Arrays.fill(DP,10001);
        DP[0] = 0;
        for(int i = 1; i <= N ;i++){
            val[i] = sc.nextInt();
            for(int j = val[i]; j <= M ;j++){
                DP[j] = Math.min(DP[j-val[i]] +1, DP[j]);
            }
        }
        int ans = DP[M] == 10001 ? -1 : DP[M];
        System.out.println(ans);
        sc.close();
    }
}
