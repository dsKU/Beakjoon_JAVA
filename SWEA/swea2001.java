package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class swea2001 {
    static int N, M;
    static int[][] map;
    static int sum_;
    static int[][] DP;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[16][16];
        DP = new int[16][16];

        int T = Integer.parseInt(st.nextToken());
        for(int t = 1 ; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sum_ = 0;
            
            for(int i = 1 ; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j <= N; j++){
                    sum_+= Integer.parseInt(st.nextToken());
                    map[i][j] = sum_ - (map[i - 1][N] - map[i - 1][j]);
                }
            }

            int ans = 0;
            for(int i = N; i >= M; i--){
                for(int j = N; j>= M; j--){
                    int temp = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
                    ans = Math.max(temp, ans);
                }
            }

            System.out.printf("#%d %d\n",t,ans);
        }


    }
}
