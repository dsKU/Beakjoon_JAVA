package Graph;
import java.io.*;
import java.util.*;

public class beakjoon11123 {
    static int N,M;
    static boolean [][] map;
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static void dfs(int y, int x){
        map[y][x] = false;

        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < M && cy >= 0 && cy < N){
                if(!map[cy][cx]) continue;
                dfs(cy, cx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    if(str.charAt(j) == '.') map[i][j] = false;
                    else map[i][j] = true;
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M;j++) {
                    if(!map[i][j]) continue;
                    cnt++;
                    dfs(i, j);
                    
                }
            }
            
            System.out.println(cnt);
        }
    }
}
