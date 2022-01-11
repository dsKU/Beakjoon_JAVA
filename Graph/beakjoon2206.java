package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beakjoon2206 {
    static int N,M;
    static int map[][][];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static ArrayList<point> p;
    static int min_ = 1000001;
    static void copy_map(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[1][i][j] = map[0][i][j];
            }
        }
    }
    static void DFS(int y,int x, int cnt,int idx){
        
        map[idx][y][x] = cnt;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < M && cy >=0 && cy < N){
                if(map[idx][cy][cx] == 0){
                    DFS(cy,cx, cnt + 1, idx);
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[2][N][M];
        p = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[0][i][j] = (str.charAt(j)-'0')*-1;
                if(map[0][i][j] == -1){
                    p.add(new point(i,j));
                }
            }
        }
        copy_map();
        DFS(0, 0, 1, 0);
        DFS(N-1, M-1, 1, 1);
        
        if(map[0][N-1][M-1] != 0){
            min_ = map[0][N-1][M-1];
        }


        for(point i : p){
            int start = 1000001;
            for(int j = 0 ; j < 4; j++){
                int cx = i.x + dx[j];
                int cy = i.y + dy[j];  
                if(cx >= 0 && cx < M && cy >=0 && cy < N){
                    if(map[0][cy][cx] > 0){
                        start = Math.min(start, map[0][cy][cx]);
                    }
                }
            }

            int end = 1000001;
            for(int j = 0 ; j < 4; j++){
                int cx = i.x + dx[j];
                int cy = i.y + dy[j];  
                if(cx >= 0 && cx < M && cy >=0 && cy < N){
                    if(map[1][cy][cx] > 0){
                        end = Math.min(end, map[1][cy][cx]);
                    }
                }
            }

            if(start != 1000001 && end != 1000001){
                min_ = Math.min(min_, start + end + 1);
            }
        }


        if(min_ == 1000001){
            System.out.println(-1);
        }
        else{
            System.out.println(min_);
        }
        
    }
}

class point{
    public int x;
    public int y;
    public point(int y, int x){
        this.x =x;
        this.y = y;
    }
}