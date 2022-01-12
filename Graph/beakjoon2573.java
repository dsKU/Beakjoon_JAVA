import java.io.*;
import java.util.*;

public class beakjoon2573 {
    static int N;
    static int M;
    static int[][][] map;
    static int[][] copy_map;
    static ArrayList<Ice> ice;
    static int max_level;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static void DFS(int level, int y, int x, int cnt){
        map[level][y][x] = cnt;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < M && cy >=0 && cy < N){
                if(map[level][cy][cx] == -1){
                    DFS(level, cy, cx, cnt);
                }
                
            }
        }
    }

    static int DFS(int level){
        int result = 0;
        for(int i =1; i <= N; i++){
            for(int j =1; j <= M; j++){
                if(map[level][i][j] == -1){
                    result++;
                    DFS(level, i, j, result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[2][N+1][M+1];
        ice = new ArrayList<>();


        for(int i =1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j <= M; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp != 0){
                    ice.add(new Ice(i,j,temp));
                    map[0][i][j] = -1;
                }
            }
        }

        int year = 0;
        int cnt = DFS(0);
        while(!ice.isEmpty() && cnt < 2){
            for(int i = 0; i< ice.size(); i++){
                Ice temp = ice.get(i);
                for(int d = 0 ; d < 4; d++ ){
                    int cx = temp.x + dx[d];
                    int cy = temp.y + dy[d];
                    if(cx > 0 && cx <= M && cy >0 && cy <= N){
                        if(map[(year) % 2][cy][cx] == 0){
                            temp.size--;
                        }
                    }
                    
                    if(temp.size == 0) break;
                }

                if(temp.size <= 0){
                    ice.remove(i--);
                }
                else{
                    map[(year + 1) % 2][temp.y][temp.x] = -1;
                }
            }
            
            map[year % 2] = new int[N+1][M+1];
            year++;
            cnt = DFS(year % 2);

        }
        if(ice.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(year);
        }

        /*
        System.out.println();
        for(int x = 0; x <= max_level-1; x++){
            for(int i =1; i <= N; i++){
                for(int j =1; j <= M; j++){
                    System.out.print(map[x][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        */
        

        
    }




}

class Ice{
    public int x;
    public int y;
    public int size;
    public Ice(int y,int x, int s){
        this.x = x;
        this.y = y;
        this.size = s;
    }
}