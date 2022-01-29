package DP;
import java.io.*;
import java.util.*;

public class beakjoon1103 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] DP;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int ans = Integer.MIN_VALUE;
    public static void solve(int y, int x, int cnt){
        if(ans == Integer.MAX_VALUE) return;
        if(DP[y][x] >= cnt) return;
        if(ans < cnt) ans = cnt;
        DP[y][x] = cnt;
        
        for(int i = 0 ; i < 4; i ++){
            int cx = x + dx[i] * map[y][x];
            int cy = y + dy[i] * map[y][x];
            if(cx < 0 || cx >= M || cy >= N || cy<0 || map[cy][cx] == -1) continue;
            if(visited[cy][cx]){
                ans = Integer.MAX_VALUE;
                return;
            }
            visited[cy][cx] = true;
            solve(cy,cx,cnt+1);
            visited[cy][cx] = false;

        }

    }
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        DP = new int[N+1][M+1];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char a = str.charAt(j);
                if(a == 'H') map[i][j] = -1;
                else map[i][j] = a - '0';
            }
        }

        solve(0, 0, 1);
       

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }
}
