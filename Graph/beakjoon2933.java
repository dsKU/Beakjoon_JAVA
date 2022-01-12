import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beakjoon2933 {
    static int R,C,N;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    static int find_idx(int turn, int temp){
        int j = 1;
        if( turn == 0){
            j = 1;
            while(j <= C && map[temp][j] != 1 ){
                j++;
            }
        }
        else{
            j = C;
            while(j >= 1 && map[temp][j] != 1){
                j--;
            }
        }
        return j;
    }
    static void DFS(int y, int x){
        visited[y][x] = true;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx > 0 && cx <= C && cy > 0 && cy <= R){
                if(map[cy][cx] == 1 && !visited[cy][cx]){
                    DFS(cy, cx);
                }
                
            }
        }
    }

    static void drop_mineral(){
        visited = new boolean[R+1][C+1];
        for(int j = 1; j <= C; j ++){       //바닥에 붙은 미네랄 탐색
            if(map[1][j] == 1 && !visited[1][j]){
                DFS(1,j);
            }
        }

        /*
        for(int i = R; i > 0; i --){
            for(int j = 1; j <= C; j ++){
                System.out.print(visited[i][j] ? '1' : '0');
            }
            System.out.println();
        }
        */

        ArrayList<point> list = new ArrayList<>();  //떨어질 미네랄 리스트에 추가
        for(int i = 2; i <= R; i ++){
            for(int j = 1; j <= C; j ++){
                if(map[i][j] == 1 && !visited[i][j]){
                    list.add(new point(i,j));
                    map[i][j] = 0;
                }
            }
        }
        if(list.isEmpty()) return;
        boolean flag = true;    //미네랄이 만날 때까지 떨어짐
        while (flag){
            for(point p : list){
                p.y--;
                if(p.y <= 1 || map[p.y-1][p.x] == 1){
                    flag = false;
                }
            }
        }

        for(point p : list){
            map[p.y][p.x] = 1;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R+1][C+1];
        for(int i = R; i > 0; i--){
            String str = br.readLine();
            for(int j = 1 ; j <= C; j++){
                if(str.charAt(j-1) == 'x'){
                    map[i][j] = 1;
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            
            int j = find_idx( i % 2, temp); //턴에 맞는 가장 가까운 미네랄 탐색
            
            if(j > 0 && j <= C){    //미네랄 제거
                map[temp][j] = 0;
            }
            
            drop_mineral();
            
        }

        print_map();

    }

    static public void print_map(){
        for(int i = R; i > 0; i--){
            for(int j = 1; j <= C; j ++){
                System.out.print(map[i][j] == 0 ? '.' : 'x');
            }
            System.out.println();
        }
    }

}

class point{
    public int x,y;

    public point(int y, int x){
        this.y = y;
        this.x = x;
    }
}