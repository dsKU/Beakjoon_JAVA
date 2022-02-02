package DP;
import java.util.*;

public class beakjoon2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] val = new int[N][2];
        int[] DP = new int[N];

        for(int i = 0 ; i < N; i++){
            val[i][0] = sc.nextInt();
            val[i][1] = sc.nextInt();
        }

        Arrays.sort(val,(a,b)->a[0] - b[0]);
        
        for(int i = 0; i < N; i++){
            DP[i] = 1;
            for(int j = 0; j < i; j++){
                if(val[i][1] > val[j][1]){
                    DP[i] = Math.max(DP[i], DP[j]+1);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(N-ans);
        sc.close();
    }
}
