package etc;
import java.io.*;
import java.util.*;
public class beakjoon11048 {
    static int N,M;
    static int[][] map;
    static int[][] DP;
    static int[] dy = {1,0,1};
    static int[] dx = {0,1,1};
    public static int solve(int y, int x){
        if(y == N && x == M) return map[y][x];
        if(DP[y][x] != -1) return DP[y][x];
        DP[y][x] = 0;

        for(int i = 0 ; i < 3; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx > M || cy > N) continue;
            DP[y][x] = Math.max(DP[y][x], solve(cy, cx) + map[y][x]);
        }

        return DP[y][x];
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        DP = new int[N+1][M+1];
        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = -1;
            }    
        }


        System.out.println(solve(1,1));
        
    }
}
