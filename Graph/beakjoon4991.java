import java.util.*;
import java.io.*;

public class beakjoon4991 {
    static int [][][]map;
    static int W,H;
    static point robot;
    static ArrayList<point> position;
    static ArrayList<point> wall;
    static int[][] arr ;
    static boolean visited[] ;
    static int ans;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static void DFS(int idx, int y, int x, int cnt){
        map[idx][y][x] = cnt;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < W && cy >=0 && cy < H){
                if(map[idx][cy][cx] > cnt + 1){
                    DFS(idx, cy,cx, cnt + 1);
                }
            }
        }
    }
    public static void DFS(){
        for(int idx = 0 ; idx < position.size(); idx++){
            for(int i=  0 ; i < H;i++){     //각idx의 맵을 최대값으로 초기화
                Arrays.fill(map[idx][i], 401);
            }
            
            for(point p : wall){            //벽 설정
                map[idx][p.y][p.x] = -1;
            }
            
            point p = position.get(idx);
            DFS(idx, p.y, p.x ,0);
            
        }
    }
    public static void bruteForce(int cnt, int sum, int idx){
        int size = position.size();
        if(cnt == size){
            ans = Math.min(ans, sum);
        }

        for(int i = 0; i < size; i++){
            if(!visited[i]){
                visited[i] = true;
                sum += arr[idx][i];
                bruteForce(cnt + 1, sum, i);
                sum -= arr[idx][i];
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int T = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());   // x
            H = Integer.parseInt(st.nextToken());   //y
            
            if(W == 0 && H == 0) break;
            position = new ArrayList<>();
            wall = new ArrayList<>();

            for(int i = 0 ; i < H; i++){    //청소기 위치, 청소할 위치, 벽의 정보를 각각 저장
                String str = br.readLine();
                for(int j = 0 ; j < W; j++){
                    char ch = str.charAt(j);
                    if(ch == 'o'){
                        robot = new point(i, j);
                    }
                    else if(ch == 'x'){
                        wall.add(new point(i, j));
                    }
                    else if(ch == '*'){
                        position.add(new point(i, j));
                    }
                }
            }
            position.add(robot); // 더러운곳 + 청소기 위치

            int map_idx = position.size();
            map = new int[map_idx][H][W];
            DFS();              
            
            arr = new int[map_idx][map_idx];
            visited = new boolean[map_idx];
            Arrays.fill(visited, false);

            ans = Integer.MAX_VALUE;

            for(int i = 0 ; i< map_idx; i++){       // 위치에 대한 거리를 그리드로 설정
                for(int j = 0 ; j < map_idx; j++){
                    point p = position.get(j);
                    arr[i][j] = map[i][p.y][p.x];
                    if(arr[i][j] == 401) ans = -1;
                }
            }
            if(ans == -1){
                System.out.println(ans);
            }
            else{
                visited[map_idx-1] = true;
                bruteForce(1, 0, map_idx-1);
                System.out.println(ans);
            }
            //브루드포스 탐색


        }
        
    }
}

class point{
    public int x;
    public int y;
    public point(int y,int x){
        this.y = y;
        this.x = x;
    }
}