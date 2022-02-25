package Graph;
import java.io.*;
import java.util.*;

public class beakjoon4485 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int N;
        int dy[] = {0 , 1, 0, -1};
        int dx[] = {-1 , 0, 1, 0};
        int[][] map = new int[125][125];
        int[][] dis = new int[125][125];
        boolean[][] visited = new boolean[125][125];
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0)break;
            for(int i = 0 ; i < N; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dis[i][j] = 987654321;
                    visited[i][j] = false;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
            pq.add(new int[]{0,0,map[0][0]});
            dis[0][0] = map[0][0];
            while(!pq.isEmpty()){
                int[] node = pq.poll();
                int y = node[0];
                int x = node[1];
                if( node[2] > dis[y][x]) continue;

                for(int i = 0 ; i < 4; i++){
                    int cx = x + dx[i];
                    int cy = y + dy[i];
                    if(cx < 0 || cy < 0 || cx >= N || cy >= N)continue;
                    if(dis[cy][cx] > map[cy][cx] + node[2]){
                        dis[cy][cx] = map[cy][cx] + node[2];
                        pq.add(new int[]{cy,cx, dis[cy][cx]});
                    }
                }

            }
            
            int ans = dis[N-1][N-1];
            sb.append("Problem ").append(t++).append(": ").append(ans).append("\n");

        }
        System.out.print(sb);

    }
}
