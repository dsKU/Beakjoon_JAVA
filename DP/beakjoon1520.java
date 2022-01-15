import java.io.*;
import java.util.*;


public class beakjoon1520 {
    static int N, M;
    static int map[][];
    static int DP[][];
    static int ans = 0;
    static int[] dx = {-1,0,1, 0};
    static int[] dy = {0,1,0, -1};
    static int solve(int y,int x){
        if(y == N-1 && x == M-1){
            return 1;
        }
        if(DP[y][x] != -1) return DP[y][x];

        DP[y][x] = 0;
        
        for(int i = 0; i < 3; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cx < M && cy >= 0 && cy < N){
                if(map[y][x] > map[cy][cx]){
                    DP[y][x] += solve(cy,cx);
                }
            }
        }
        return DP[y][x];
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        DP = new int[N][M];

        for(int i = 0 ; i < N ;i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ;j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j]--;
            }
        }
        
        System.out.println(solve(0, 0));
    }    

}
