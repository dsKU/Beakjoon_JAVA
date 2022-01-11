package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class beakjoon14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] time = new int[N+1];
        int[] score = new int[N+1];
        int[][] DP = new int[N+1][100001];
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= T; j++){
                if(time[i] <= j){
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j - time[i]] + score[i]);
                }
                else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }


        System.out.println(DP[N][T]);
    }
}
