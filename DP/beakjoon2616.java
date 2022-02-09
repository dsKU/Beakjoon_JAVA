package DP;
import java.io.*;
import java.util.*;

public class beakjoon2616 {
    static int N,M;
    static int sumArr[];
    static int[][] DP;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        sumArr = new int[N+1];
        DP = new int[N+1][3];

        st = new StringTokenizer(br.readLine());
        for(int i = 1  ; i <= N; i++){
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        
        for(int i = M; i <= N - (M * 2); i++){
            DP[i][0] = Math.max(sumArr[i] - sumArr[i-M], DP[i - 1][0]);
        }
        for(int j = M+M; j <= N - M; j++){
            DP[j][1] = Math.max(sumArr[j] - sumArr[j-M] + DP[j-M][0], DP[j - 1][1]);
        }
        for(int j = M+M+M; j <= N; j++){
            DP[j][2] = Math.max(sumArr[j] - sumArr[j-M] + DP[j-M][1], DP[j - 1][2]);
        }

        System.out.println(DP[N][2]);
    }
}
