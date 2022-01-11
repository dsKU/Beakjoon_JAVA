package implemented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon2639 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][] map;
    static int[][] pre_map;
    static boolean[][] visited;
    static int N;
    static int M;

    static public void search_blank(int x, int y, int d){
        map[d][x][y] = 9;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cx < N && cy >= 0 && cy < M){
                if(map[d][cx][cy] == 0)
                search_blank(cx,cy,d);
            }
        }
    }
    static public void melt_cheese(int x, int y, int d){
        for(int i = 1 ; i < N - 1; i ++){
            for(int j = 1 ; j < M - 1; j ++){
                if(map[d][i][j] == 1){
                    int air = 0;
                    map[(d+1) % 2][i][j] = 1;
                    for(int k = 0; k < 4; k++){
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if(map[d][cx][cy] == 9){
                            air ++;
                        }
                        if(air >= 2){
                            map[(d+1) % 2][i][j] = 0;
                            break;
                        }
                    }


                }
                
            }
        }
    }
    static public int count_cheese(int d){
        int result = 0;
        for(int i = 1 ; i < N ; i ++){
            for(int j = 1 ; j < M ; j ++){
                if(map[d][i][j] == 1)
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
        map = new int[2][N][M];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int turn = 0;

        while(true){
            search_blank(0,0,turn % 2);
            int cnt = count_cheese(turn % 2);
            if(cnt == 0){
                break;
            }

            turn++;
            melt_cheese(0, 0, (turn - 1) % 2);
            map[(turn - 1) % 2] = new int[N][M];
        }
        
        System.out.println(turn);


    }
}
