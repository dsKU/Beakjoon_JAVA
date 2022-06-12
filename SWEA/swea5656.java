import java.io.*;
import java.util.*;

public class swea5656 {
    static int N;
    static int W;
    static int H;
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};

    static int[][][] map = new int[5][15][12];
    static int ans = Integer.MAX_VALUE;
    static int countBlock(){
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[N][i][j] != 0) cnt++;
            }
        }

        return cnt;
    }
    static void copy(int n){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[n+1][i][j] = map[n][i][j];
            }
        }
    }
    static void sortMap(int n,int h, int w){
        int s = 0;
        
        while(h >= 0 && map[n][h][w] != 0){
            h--;
        }
        s = h--;
        while(h >= 0){
            if(map[n][h][w] != 0) {
                map[n][s][w] = map[n][h][w];
                map[n][h][w] = 0;
                s--;
            }
            h--;
        }
    }

    static void bumb(int n, int w){
        //n은 복사할 map
        copy(n);
        int nextN = n+1;
        int h = 0;
        while(h < H && map[n][h][w] == 0){
            h++;
        }

        if(h == H) return;
        
        
        map[nextN][h][w] = 0;
        if(map[n][h][w] == 1){
            sortMap(n+1,h, w);
            return;
        } 

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{h,w});

        while(!que.isEmpty()){
            int[] node = que.poll();
            int dis = map[n][ node[0] ][ node[1] ];

            for(int i = 0 ; i < 4; i++){
                int cx = node[1];
                int cy = node[0];  
                for(int j = 1; j < dis; j++){
                    cx = cx + dx[i];
                    cy = cy + dy[i];  
                    if(cx < 0 || cx >= W || cy < 0 || cy >= H) break;
                    if(map[nextN][cy][cx] > 1){
                        que.add(new int[]{cy,cx});
                    }
                    map[nextN][cy][cx] = 0;

                }   //end for
            }   //end for 
        }   //end while queue

        for (int i = 0; i < W; i++) {
            sortMap(nextN,H-1, i);
        }
        
    }   //end method

    static void solve(int n){
        if(n >= N){
            int temp = countBlock();
            ans = Math.min(temp, ans);
            // if(temp == 10){
            //     for (int z = 0; z < H; z++) {
            //         for (int j = 0; j < W; j++) {
            //             System.out.print(map[N][z][j] + " ");
            //         }
            //         System.out.println();
            //     }
            //     System.out.println();
            // }
            return;
        }

        for(int i = 0 ; i < W; i++){
            bumb(n, i);
            solve(n+1);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        System.out.println("true".equals(null));

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[0][i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = Integer.MAX_VALUE;
            solve(0);

            

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
