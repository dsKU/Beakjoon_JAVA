package implemented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon2636 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][] map;
    static int[][] pre_map;
    static boolean[][] visited;
    static int N;
    static int M;

    static public void search_blank(int x, int y, int d){
        map[x][y][d] = 9;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cx < N && cy >= 0 && cy < M){
                if(map[cx][cy][d] == 0)
                //if(!visited[cy][cx] && map[cx][cy] == 0)  && map[cx][cy][(d + 1) % 2] == 0 이전맵이 
                search_blank(cx,cy,d);
            }
        }
    }
    static public void melt_cheese(int x, int y, int d){
        for(int i = 0 ; i < N; i ++){
            for(int j = 0 ; j < M; j ++){
                if(map[i][j][d] == 9){
                    for(int k = 0; k < 4; k++){
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if(cx >= 0 && cx < N && cy >= 0 && cy < M){
                            if(map[cx][cy][d] == 1)
                                map[cx][cy][d] = 0;
                        }
                    }
                    map[i][j][d] = 0;
                }
                
            }
        }
    }
    static public int count_cheese(int d){
        int result = 0;
        for(int i = 1 ; i < N ; i ++){
            for(int j = 1 ; j < M ; j ++){
                if(map[i][j][d] == 1)
                    result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M][2];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }
        int turn = 0;
        int ans = count_cheese(0);

        
        while(true){
            
            search_blank(0,0,0);
            int cnt = count_cheese(0);
            if(cnt == 0){
                break;
            }
            ans = cnt;
            turn++;
            melt_cheese(0, 0, 0);
        }
        

        
        /*
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                System.out.print(map[i][j][0] + " ");
            }
            System.out.println();
        }
        */

        System.out.println(turn);
        System.out.println(ans);


    }
}
