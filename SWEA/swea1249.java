import java.io.*;
import java.util.*;
public class swea1249 {
    static int N;
    static int[][] map = new int[100][100];
    static int[][] val = new int[100][100];
    static PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->a[2]-b[2]);

    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static void solve(){
        que.clear();
        que.add(new int[]{0,0,0});
        map[0][0] = 0;
        while(!que.isEmpty()){
            int[] node = que.poll();

            if(node[0] == N-1 && node[1] == N-1) return;


            for(int i = 0 ; i < 4; i++){
                int cx = node[1] + dx[i];
                int cy = node[0] + dy[i];  
                if(cx < 0 || cx >= N || cy < 0 || cy >= N)  continue;
                int temp = node[2] + map[cy][cx];
                if(val[cy][cx] > temp){
                    val[cy][cx] = temp;
                    que.add(new int[]{cy,cx, temp});
                }
            }


        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t= 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    val[i][j] = Integer.MAX_VALUE;
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            solve();
            sb.append("#").append(t).append(" ").append(val[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
    }
}
