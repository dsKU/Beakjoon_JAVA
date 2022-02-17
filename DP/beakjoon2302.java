package DP;
import java.io.*;
import java.util.*;

public class beakjoon2302 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        boolean[] VIP = new boolean[N+1];
        int[] DP = new int[N+1];
        M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            VIP[Integer.parseInt(br.readLine())] = true;
        }
        DP[1] = 1;
        DP[0] = 1;
        for(int i = 2; i <= N ; i++){
            if(VIP[i] || VIP[i-1]){
                DP[i] = DP[i-1];
            }
            else{
                DP[i] = DP[i-1] +  DP[i-2];
            }
        }
        System.out.println(DP[N]);
    }
}
