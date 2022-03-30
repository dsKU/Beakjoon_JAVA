package Graph;
import java.io.*;
import java.util.*;

public class beakjoon13460 {
    static int N,M;
    static char[][][] map;
    static int[][] red;
    static int[][] blue;
    static int[] hole = {0,0};
    static int[] dy = {0,1,0,-1};
    static int[] dx = {-1,0,1,0};
    static int ans = 11;
    static void copy(int depth){
        int pre = depth-1;
        for(int i =0  ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[pre][i][j] == 'R' || map[pre][i][j] == 'B'){
                    map[depth][i][j] = '.';
                }
                else map[depth][i][j] = map[pre][i][j];
            }
        }
    }
    static void solve(int depth){
        if(ans < depth) return;
        if(depth > 10) return;
        
        for(int i = 0 ; i < 4; i++){
            copy(depth);
            // 빨간 공과 파란 공의 움직인 거리를 구함
            int red_move = move('R', depth - 1, i);
            int blue_move = move('B', depth - 1, i);
            
            // 파란공이 구멍에 들어가면 더이상 측정하지 않음
            int by = blue[depth-1][0] + (dy[i] * blue_move);
            int bx = blue[depth-1][1] + (dx[i] * blue_move);
            if(map[depth][by][bx] == 'O') continue;

            int ry = red[depth-1][0] + (dy[i] * red_move);
            int rx = red[depth-1][1] + (dx[i] * red_move);
            //빨간 구멍만 구멍에 들어가면 해당 deepth가 정답임으로 더이상 측정할 필요가 없음
            if(map[depth][ry][rx] == 'O') {
                ans = depth;
                return;
            }

            //만약 도착한 좌표가 같을 경우 더 적게 움직인 공이 해당 좌표를 차지하고
            //더 많이 움직인 경우 그 전 좌표를 가짐
            if(by == ry && bx == rx){
                if(red_move < blue_move){//레드가 클 경우
                    red[depth][0] = ry;
                    red[depth][1] = rx;
                    blue[depth][0] = by - dy[i];
                    blue[depth][1] = bx - dx[i];
                }
                else{
                    blue[depth][0] = by;
                    blue[depth][1] = bx;
                    red[depth][0] = ry - dy[i];
                    red[depth][1] = rx - dx[i];;
                }
            }
            else{   //같은 좌표가 아니라면 그냥 업데이트
                red[depth][0] = ry;
                red[depth][1] = rx;
                blue[depth][0] = by;
                blue[depth][1] = bx;
            }
            solve(depth + 1);
        }
    }

    static int move(char ch, int depth, int dir){
        int ret = 0;
        int y = ch == 'B' ? blue[depth][0] : red[depth][0];
        int x = ch == 'B' ? blue[depth][1] : red[depth][1];
        
        while(true){
            //System.out.println(ch + " " + y + " " + x);
            if(map[depth][ y + dy[dir] ][ x + dx[dir] ] == 'O'){
                ret++;
                break;
            } 
            if(map[depth][ y + dy[dir] ][ x + dx[dir] ] == '#') break;
            y += dy[dir];
            x += dx[dir];
            ret ++;
        }

        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[12][N][M];
        red = new int[12][2];
        blue = new int[12][2];
        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M; j++){
                char ch = str.charAt(j);
                
                if( ch == 'B'){
                    blue[0][0] = i;
                    blue[0][1] = j;
                    map[0][i][j] = 'B';
                }
                else if(ch == 'R'){
                    red[0][0] = i;
                    red[0][1] = j;
                    map[0][i][j] = 'R';
                }
                else{
                    map[0][i][j] = ch;
                }
            }
        }

        solve(1);
        //printMap(1);
        if(ans == 11){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
    static void printMap(int depth){
        int by = blue[depth][0];
        int bx = blue[depth][1];
        int ry = red[depth][0];
        int rx = red[depth][1];
        map[depth][by][bx] = 'B';
        map[depth][ry][rx] = 'R';

        for(int i = 0  ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                System.out.print(map[depth][i][j]);
            }
            System.out.println();
        }
    }
}
