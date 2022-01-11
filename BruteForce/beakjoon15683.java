package BruteForce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class point{
    public int type;
    public int x;
    public int y;
    public point(int t, int a, int b){
        type = t;
        x = a;
        y = b;
    }
}

public class beakjoon15683 {
    static int[][][] map;
    static ArrayList<point> CCTV;
    static boolean[] visited;
    static int N;
    static int M;
    static int K;
    static int ans = Integer.MAX_VALUE;
    static public void fill_area(int depth, point p, int direction){
        if(direction == 0){
            for(int a = p.y - 1; a >= 0; a--){
                if(map[depth][p.x][a] == 6) break;
                map[depth][p.x][a] = -1;    
            }
        }
        else if(direction == 2){
            for(int a = p.y + 1; a < M; a++){
                if(map[depth][p.x][a] == 6) break;
                map[depth][p.x][a] = -1;    
            }
        }
        else if(direction == 1){
            for(int a = p.x - 1; a >= 0; a--){
                if(map[depth][a][p.y] == 6) break;
                map[depth][a][p.y]  = -1;    
            }
        }
        else if(direction == 3){
            for(int a = p.x + 1; a < N; a++){
                if(map[depth][a][p.y] == 6) break;
                map[depth][a][p.y]  = -1;    
            }
        }
    }
    static public void area_type(int depth, point p, int direction){
        if(p.type == 1){
            fill_area(depth, p, direction);
        }
        else if(p.type == 2){
            fill_area(depth, p, direction);
            fill_area(depth, p, direction + 2);
        }
        else if(p.type == 3){
            fill_area(depth, p, direction);
            fill_area(depth, p, (direction + 1) % 4);
        }
        else if(p.type == 4){
            fill_area(depth, p, direction);
            fill_area(depth, p, (direction + 1) % 4);
            fill_area(depth, p, (direction + 2) % 4);
        }
    }

    static public void DFS(int depth){
        if(depth == K+1){
            int temp = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[K][i][j] == 0){
                        temp++;
                    }
                }
            }
            ans = Math.min(ans,temp);
            return;
        }
        
        if(visited[depth - 1]) DFS(depth + 1);
        point p = CCTV.get(depth - 1);
        int cnt = p.type == 2 ? 2 : 4;

        for(int j = 0; j < cnt; j ++){
            for(int x = 0; x < N; x++){   //copy array
                for(int y = 0; y < M; y++){
                    map[depth][x][y] = map[depth-1][x][y];
                }   
            }
            
            area_type(depth, p, j);
            visited[depth] = true;
            DFS(depth + 1);
        }

    }//end function

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[9][N+1][M+1];
        CCTV = new ArrayList<point>();
        
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[0][i][j] = Integer.parseInt(st.nextToken());
                if(map[0][i][j] != 0 && map[0][i][j] != 6){
                    CCTV.add(new point(map[0][i][j], i, j));
                }
            }
        }
        K = CCTV.size();
        visited = new boolean[CCTV.size()+1];
        Arrays.fill(visited, false);

        for(int i = 0 ; i < CCTV.size(); i++){
            point p = CCTV.get(i);
            if(p.type == 5){
                visited[i] = true;
                fill_area(0, p, 0);
                fill_area(0, p, 1);
                fill_area(0, p, 2);
                fill_area(0, p, 3);

            }
        }
        

        DFS(1);
        System.out.println(ans);
    }
}
