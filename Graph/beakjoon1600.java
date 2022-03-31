package Graph;
import java.io.*;
import java.util.*;
public class beakjoon1600 {
    static int K,N,M;
    static boolean[][] map;
    static int[][][] visited;
    static int[] specialY = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] specialX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void solve(){
        Queue<int[]> queue = new LinkedList<>();
        //int[] = {y , x, 남은 슈퍼 점프}
        queue.add(new int[]{0, 0, K});
        map[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i = 0 ; i < 4; i++){
                int cx = node[1] + dx[i];
                int cy = node[0] + dy[i];  
                if(cx < 0 || cx >= M || cy < 0 || cy >=N) continue;
                if(map[cy][cx]) continue;
                if(visited[node[2]][cy][cx] != 0) continue;
                
                visited[node[2]][cy][cx] = visited[node[2]][node[0]][node[1]] + 1;
                queue.add(new int[]{cy, cx, node[2]});
            }

            if(node[2] == 0) continue;

            for(int i = 0; i < 8 ; i++){
                int cx = node[1] + specialX[i];
                int cy = node[0] + specialY[i];  
                if(cx < 0 || cx >= M || cy < 0 || cy >= N) continue;
                if(map[cy][cx]) continue;
                if(visited[node[2] - 1][cy][cx] != 0) continue;
                
                visited[node[2]-1][cy][cx] = visited[node[2]][node[0]][node[1]] + 1;

                queue.add(new int[]{cy, cx, node[2]-1 });
            }
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;;// = new StringTokenizer(br.readLine());

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[K+1][N][M];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            }
        }
        if(N == 1 && M == 1) {
            System.out.println(0);
            return;
        }
        solve();
        int ans = 987654321;
        for(int i = 0 ; i <= K; i++){
            if(visited[i][N-1][M-1] != 0){
                ans = Math.min(ans, visited[i][N-1][M-1]);
            }
        }
        if( ans == 987654321) ans = -1;
        System.out.println(ans);
    }

}
