package SWEA_JAVA;
import java.io.*;
import java.util.*;


public class swea1861 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] cnt;
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static public int BFS(int y,int x){
        int ret = 1;
        int tx = x;
        int ty = y;
        while(true){
            boolean flag = true;
            for(int i = 0 ; i < 4; i++){
                int cx = tx + dx[i];
                int cy = ty + dy[i];  
                if(cx >= 0 && cx   < N && cy >=0 && cy < N){
                    if(map[cy][cx] - map[ty][tx] == 1){
                        tx = cx; ty = cy;
                        
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) break;
            ret ++;
        }
        

        cnt[y][x] = ret;
        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            cnt = new int[N][N];

            for(int i= 0; i< N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans1 = 0;
            int ans2 = 0;
            for(int i= 0; i< N; i++){
                for(int j = 0; j < N; j++){
                    if(cnt[i][j] == 0) BFS(i, j);

                    if(ans1 < cnt[i][j]){
                        ans1 = cnt[i][j];
                        ans2 = map[i][j];
                    }
                    else if(ans1 == cnt[i][j] && map[i][j] < ans2){
                        ans2 = map[i][j];
                    }

                    System.out.printf("%3d", cnt[i][j]);
                }
                System.out.println();
            }

            sb.append("#").append(t).append(" ").append(ans2).append(" ").append(ans1).append("\n");
        }
        System.out.print(sb);
    }
}
