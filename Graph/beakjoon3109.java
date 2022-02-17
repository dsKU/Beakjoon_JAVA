package Graph;
import java.io.*;
import java.util.*;
public class beakjoon3109 {
    static int N,M;
    static char map[][] ;
    static boolean[][] visited;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    static int ans = 0;
    static boolean flag = false;
    static void solve(int y, int x){
        if(x >= M - 1 && !flag) {
            ans ++;
            flag = true;
            return;
        }

        for(int i = 0 ; i < 3; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cy < 0 || cy >= N || visited[cy][cx]) continue;
            if(map[cy][cx] == 'x' || flag) continue;
            visited[cy][cx] = true;
            solve(cy, cx);
        }
        
        
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String str =br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 0 ; i < N; i++){
            flag = false;
            visited[i][0] = true;
            solve(i, 0);
        }
        System.out.println(ans);
    }
}
