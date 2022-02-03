package DP;
import java.io.*;
import java.util.*;

public class beakjoon7579 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] memory = new long[N];
        int[] cost = new int[N];
        long[] bag = new long[10001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i = 0; i < N; i++){
            int c = cost[i];
            for(int j = 10000; j >= c; j--){
                bag[j] = Math.max(bag[j], bag[j-c] + memory[i]);
            }
        }
        long ans = 0;
        for(int i = 0 ; i <= 10000; i++){
            if(bag[i] >= M){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
