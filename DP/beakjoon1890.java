package DP;
import java.io.*;
import java.util.*;
public class beakjoon1890 {
    static int N;
    static int [][] map;
    static long [][] dp;
    static long solve(int y, int x){
        if(y == N-1 && x == N-1) return 1;
        if(dp[y][x] != 0) return dp[y][x];
        if(map[y][x] == 0) return 0;
        long ret = 0;
        
        if(y + map[y][x] < N){
            ret += solve(y + map[y][x], x);
        }
        if(x + map[y][x] < N){
            ret += solve(y, x + map[y][x]);
        }

        return dp[y][x] = ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new long[N][N];

        dp[0][0] = 1;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) continue;
                if(i + map[i][j] < N) dp[i + map[i][j] ][ j] += dp[i][j];
                if(j + map[i][j] < N) dp[i][ j + map[i][j] ] += dp[i][j];
            }
        }


        System.out.println(dp[N-1][N-1]);

    }
}
