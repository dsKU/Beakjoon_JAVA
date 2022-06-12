import java.io.*;
import java.util.*;
public class swea1953 {
    static int N,M, R,C,L;
    static int[][] map;
    static boolean[][] visit;
    static int ans = 0;
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static int[][] pipe = {{}, {0,1,2,3}, {1,3}, {0,2}, {3,2}, {1,2}, {0,1}, {0,3}};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());


        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Queue<int[]> que = new ArrayDeque<>();
        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            L = Integer.parseInt(st.nextToken());

            map = new int[N+1][M+1];
            visit = new boolean[N+1][M+1];
            
            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            que.clear();
            que.add(new int[]{R,C, 1});
            visit[R][C] = true;
            ans = 1;

            while(!que.isEmpty()){
                int[] node = que.poll();

                for(int i : pipe[ map[ node[0] ][ node[1] ] ]){
                    int cx = node[1] + dx[i];
                    int cy = node[0] + dy[i];  
                    if(cx < 0 || cx >= M || cy < 0 || cy >= N)  continue;
                    if(node[2] == L)continue;
                    if(!check(i, map[cy][cx]) || visit[cy][cx]) continue;
                    
                    ans++;
                    que.add(new int[]{cy,cx,node[2] + 1 });
                    visit[cy][cx] = true;
                }
            }

            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
//    static int dx[] = {-1 , 0, 1, 0};
//    static int dy[] = {0 , 1, 0, -1};
    static boolean check(int d, int next){
        switch (d) {
            case 0:
                if(next == 1 || next == 3 || next == 4 || next == 5 ) return true;
            break;
            case 1:
                if(next == 1 || next == 2 || next == 4 || next == 7 ) return true;
            break;
            case 2:
                if(next == 1 || next == 3 || next == 6 || next == 7 ) return true;
            break;
            case 3:
                if(next == 1 || next == 2 || next == 5 || next == 6 ) return true;
            break;
                default:
                break;
        }
        return false;
    }
}
