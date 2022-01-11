package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon14502 {
    static int N,M;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int map[][];
    static int copy[][];
    static int max_;
    static boolean[][] visited;

    static void copy_map(){
        copy= new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = map[i][j];
            }
        }
    }

    static void DFS(int y, int x){
        if(copy[y][x] == 1) return;
        copy[y][x] = 2;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < M && cy >=0 && cy < N){
                if(copy[cy][cx] == 0){
                    DFS(cy,cx);
                }
            }
        }
    }

    static void wall(int y, int x, int cnt){
        if(cnt == 3){
            copy_map();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copy[i][j] == 2){
                        DFS(i, j);
                    }
                }
            }
            int save = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copy[i][j] == 0){
                        save ++;
                    }
                }
            }

            max_ = Math.max(max_, save);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    map[i][j]=1;
                    visited[i][j] = true;
                    wall(i,j,cnt+1);
                    visited[i][j] = false;
                    map[i][j] = 0;
                }
            }
        }
        /*for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < M && cy >=0 && cy < N){
                if(map[cy][cx] == 0){
                    map[cy][cx] = 1;
                    wall(cy,cx,cnt+1);
                    map[cy][cx] = 0;
                }
            }
        }*/

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    visited[i][j] = true;
                    map[i][j]=1;
                    wall(i,j,1);
                    map[i][j]=0;
                }
            }
        }
        
        
        System.out.println(max_);

    }
}
