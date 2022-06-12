import java.io.*;
import java.util.*;

public class swea1768 {
    static int N;
    static int[][] map = new int[12][12];
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static int[][] point = new int[12][2];
    static int idx = 0;
    static int maxCore = 0;
    static int dis = 0;

    static void solve(int len, int core, int cnt){
        if(cnt == idx){
            if(core > maxCore){
                maxCore = core;
                dis = len;
            }
            else if(core == maxCore){
                if(dis > len){
                    dis = len;
                }
            }
            return;
        }

        for(int i = 0 ; i < 4; i++){
            int cx = point[cnt][1];
            int cy = point[cnt][0];
            int temp = 0;

            while(true){
                cx = cx + dx[i];
                cy = cy + dy[i];
                if(cx >= N || cx < 0 || cy >= N || cy < 0) break;
                if(map[cy][cx] != 0){
                    temp = 0;
                    break;
                }
                temp++;
            }//거리구하기
            
            cx = point[cnt][1];
            cy = point[cnt][0];
            for (int j = 0; j < temp; j++) {
                cx = cx + dx[i];
                cy = cy + dy[i];
                map[cy][cx] = 1;
            }  //구한 거리만큼 채우기

            if(temp == 0){
                solve(len, core, cnt+1);
            }
            else{
                solve(len+temp, core+1, cnt+1);

                cx = point[cnt][1];
                cy = point[cnt][0];
                for (int j = 0; j < temp; j++) {
                    cx = cx + dx[i];
                    cy = cy + dy[i];
                    map[cy][cx] = 0;
                }  //구한 거리만큼 채우기
            }
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            idx = 0;
            maxCore = 0;
            dis = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], 0);

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if(Integer.parseInt(st.nextToken()) == 1){
                        map[i][j] = 1;
                        if(i == 0 || i == N - 1 || j == 0 || j == N-1) continue;
                        point[idx][0] = i;
                        point[idx++][1] = j;
                    } 
                    else map[i][j] = 0;
                }
            }

            solve(0, 0, 0);

            sb.append("#").append(t).append(" ").append(dis).append("\n");
        }
        System.out.print(sb);
    }
}
