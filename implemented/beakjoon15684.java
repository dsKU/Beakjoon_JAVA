package implemented;
import java.io.*;
import java.util.*;

public class beakjoon15684 {
    static int N, M, H;
    static int[][] map;
    static int[][] role;
    static int min_ = 4;
    static ArrayList<point> possible;

    static boolean check(){
        boolean result = true;

        for(int i =1 ; i <= N; i++){
            if(map[H][i] != i) return false;
        }
        return result;
    }

    static void DFS(int h, int cnt){
        if(cnt >= min_) return;
        if(playAndCheck()){
            
            min_ = Math.min(min_, cnt);
            return;
        }

        for(point p : possible){
            if(p.y >= h && role[p.y][p.x] == 0 && role[p.y][p.x+1] == 0){
                role[p.y][p.x] = 1; role[p.y][p.x + 1] = - 1;
                DFS(p.y, cnt+1);
                role[p.y][p.x] = 0 ;role[p.y][p.x + 1] = 0;
            }
        }

    }
    static boolean playAndCheck(){
        //print_map();
        //System.out.println();
        for(int i = 1; i <= H; i++){
            for(int j = 1 ; j <= N; j++){
                map[i][j] = map[i-1][j + role[i][j]];
            }
        }

        for(int i =1 ; i <= N; i++){
            if(map[H][i] != i) return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1];
        role = new int[H+1][N+1];
        possible = new ArrayList<>();
        for(int i = 1 ; i <= N; i++){
            map[0][i] = i;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            role[a][b] = 1; role[a][b + 1] = -1;
        }

        for(int i = 1; i <= H; i++){
            for(int j = 1; j < N;j++){
                if(role[i][j] == 0 && role[i][j+1] == 0){
                    possible.add(new point(i, j));
                }
            }
        }
        DFS(1,0);

        //print_map();
        if(min_ == 4) System.out.println(-1);
        else System.out.println(min_);

    }
    static void print_map(){
        for(int i = 1 ; i <= H; i++){
            for(int j = 1 ; j <= N; j++){
                System.out.print(role[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class point{
    int y,x;
    public point(int y,int x){
        this.y = y;
        this.x = x;

    }
}