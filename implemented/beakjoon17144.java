package implemented;
import java.io.*;
import java.util.*;


public class beakjoon17144 {
    static int R,C,T;
    static int[][] map;
    static int[][] copyMap;
    static int[][] cleaner = new int[2][2];
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static int top[] = {2, 3, 0, 1};
    static int bottom[] = {2, 1, 0, 3};
    static void spread(){
        Queue<point17144> que = new LinkedList<>();
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++){
                if(map[i][j] > 4) 
                que.add(new point17144(i, j, map[i][j]));
            }
        }

        while(!que.isEmpty()){
            point17144 node = que.poll();

            int t = node.v / 5;
            for(int i = 0 ; i < 4; i++){
                int cy = node.y + dy[i];  
                int cx = node.x + dx[i];
                if(cx < 0 || cx >= C || cy < 0 || cy >= R) continue;
                if(map[cy][cx] >= 0){
                    map[cy][cx] += t;
                    map[node.y][node.x] -= t;
                } 
            }
        }
    }
    static void clean(int y, int x, int[] cw){
        int a = y;
        int b = x+1;
        map[a][b] = 0;
        for(int i = 0 ; i < 4; i++){
            while(true){
                int cy = a + dy[cw[i]];
                int cx = b + dx[cw[i]];
                
                if(cx < 0 || cx >= C || cy < 0 || cy >= R) break;
                if(cy == y && cx == x) break;

                map[cy][cx] = copyMap[a][b];
                a = cy;
                b = cx;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        copyMap = new int[R][C];

        int idx = 0;
        for(int i = 0 ; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    cleaner[idx][0] = i;
                    cleaner[idx++][1] = j;
                }
            }
        }

        while(T-- > 0){
            spread();
            copy();
            clean(cleaner[0][0], cleaner[0][1], top);
            clean(cleaner[1][0], cleaner[1][1], bottom);
        }

        int ans = 0;
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++){
                //if(map[i][j] > 0)
                ans += map[i][j];
            }
        }
        ans+=2;
        System.out.println(ans);
    }
    static void copy(){
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
}

class point17144{
    int y,x, v;
    public point17144(int a, int b, int c){
        y = a;
        x = b;
        v = c;
    }
}