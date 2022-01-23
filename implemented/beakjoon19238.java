package implemented;
import java.io.*;
import java.util.*;

public class beakjoon19238 {
    static int N;
    static int M;
    static int oil;
    static int[][] map_ori;
    static int[][] map;

    static ArrayList<point19238> person;
    static ArrayList<point19238> goal;
    static point19238 car;
    static int max_value = 401;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    static void DFS(int y,int x, int cnt){
        map[y][x] = cnt;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx > 0 && cx <= N && cy > 0 && cy <= N){
                if(map[cy][cx] != -1 && map[cy][cx] > cnt + 1){
                    DFS(cy,cx, cnt + 1);
                }
            }
        }
        
    }
    public static void DFS(point19238 p){
        map = new int[N+1][N+1];
        for(int i= 1 ; i <= N;i ++){
            for(int j= 1 ; j <= N;j ++){
                map[i][j] = map_ori[i][j] == 0 ? 401 : -1;                
            }
        }
        DFS(p.y, p.x, 0);
    }
    
        
    public static void main(String[] args) throws Exception {
        input();
        point19238 g = car;
        
        while(!person.isEmpty()){
            DFS(g);
            for(point19238 p :person){
                if(map[p.y][p.x] == 401){
                    System.out.println(-1);
                    return;
                }
            }
            
            int min_ = 0;
            
            for(int i = 1; i < person.size(); i++){
                point19238 p = person.get(i);
                point19238 m = person.get(min_);
                if(map[m.y][m.x] == map[p.y][p.x]){     //거리가 같을 때 우선순위
                    if(m.y == p.y){
                        min_ = m.x > p.x ? i : min_;
                    }    
                    else{
                        min_ = m.y > p.y ? i : min_;
                    }
                }
                else if(map[m.y][m.x] > map[p.y][p.x]){
                    min_ = i;
                }
            }

            point19238 m = person.get(min_);
            m = person.get(min_);
            oil -= map[m.y][m.x];
    
            DFS(m);
            for(point19238 p : goal){
                if(map[p.y][p.x] == 401){
                    System.out.println(-1);
                    return;
                }
            }
            
            g = goal.get(min_);
            if(oil - map[g.y][g.x] < 0){
                System.out.println(-1);
                return;
            }
            oil += map[g.y][g.x];
            person.remove(min_);
            goal.remove(min_);
        }

        System.out.println(oil);
        /*
        System.out.println(min_);
            for(int i= 1 ; i <= N;i ++){
                for(int j= 1 ; j <= N;j ++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        System.out.println();
        */
        



    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        
        person = new ArrayList<>(); //사람
        goal = new ArrayList<>();   //도착지
        map_ori = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                map_ori[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int car_y = Integer.parseInt(st.nextToken());
        int car_x = Integer.parseInt(st.nextToken());
        car = new point19238(car_y,car_x);
        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            person.add(new point19238(y, x));
            goal.add(new point19238(a, b));
            
        }
        


    }
}




class point19238{
    public int x;
    public int y;
    public point19238(int y, int x){
        this.x = x;
        this.y = y;
    }
}