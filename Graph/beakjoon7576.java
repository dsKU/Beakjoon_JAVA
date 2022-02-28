package Graph;
import java.io.*;
import java.util.*;


public class beakjoon7576 {
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) que.add(new int[]{i,j});
            }
        }

        while(!que.isEmpty()){
            int[] node = que.poll();
            
            for(int i = 0 ; i < 4; i++){
                int cy = node[0] + dy[i];
                int cx = node[1] + dx[i];
                if(cx < 0 || cy < 0 || cx >= M || cy >= N) continue;
                if(map[cy][cx] != 0) continue;

                map[cy][cx] = map[node[0]][node[1]] + 1;
                que.add(new int[]{cy,cx});
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                else{
                    if(ans < map[i][j]) ans = map[i][j];
                }
            }
        }
        System.out.println(ans-1);
    }
}
