package implemented;
import java.io.*;
import java.util.*;

public class beakjoon12100 {
    static int N,M;
    static int[][] map_;
    static int ans = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean equal(int[][] map1, int[][] map2){
        for(int i = 0  ; i < N; i++){
            for(int j = 0  ; j < N; j++){
                if(map1[i][j] != map2[i][j])return false;
            }
        }
        return true;
    }
    static int search_max(int[][] map){
        int ret = 0;
        for(int i = 0  ; i < N; i++){
            for(int j = 0  ; j < N; j++){
                if(map[i][j] > ret){
                    ret = map[i][j];
                }
            }
        }
        return ret;
    }
    static int[][] MapCopy(int[][] map){
        int[][] copy = new int[N][N];
        for(int i = 0  ; i < N; i++){
            for(int j = 0  ; j < N; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
    static void move(int[][] map, int d){
        if(d < 2){  //y고정
            for(int i = 0 ; i < N; i++){
                int cx = d == 0 ? N-2 : 1;  //검사할 자리
                int x = d == 0 ? N-1 : 0;   //업데이트 될 자리
                
                while(cx < N && cx >= 0){   //전부 순회하면 종료
                    if(map[i][cx] != 0){    // 해당 자리가 0이 아니고
                        if(map[i][x] == 0){ // 업데이트 될 자리가 0이면
                            map[i][x] = map[i][cx]; //업데이트 될 자리에 업데이트
                            map[i][cx] = 0; //중복방지 초기화
                        }
                        else if(map[i][x] == map[i][cx]){   //값이 같으면
                            map[i][x] += map[i][cx];    //더해주고
                            map[i][cx] = 0;    //두 자리 모두 초기화
                            x += dx[d];
                            map[i][x] = 0;  //여기는 마지막에 이 case가 되면  내가 짠 코드는 그대로 남아서 초기화해줘야함
                        }
                        else{
                            x += dx[d];
                            map[i][x] = map[i][cx]; //남은 경우 
                            
                        }
                    }

                    cx += dx[d];    //검사자리 이동
                }
                x += dx[d];
                while(x < N && x >= 0){
                    map[i][x] = 0;
                    x += dx[d];
                }
                
            }//end for
        }//end if
        else{   //x고정
            for(int i = 0 ; i < N; i++){
                int cy = d == 2 ? N-2 : 1;
                int y = d == 2 ? N-1 : 0;
                while(cy < N && cy >= 0){
                    if(map[cy][i] != 0){
                        if(map[y][i] == 0){
                            map[y][i] = map[cy][i];
                            map[cy][i] = 0;
                        }
                        else if(map[y][i] == map[cy][i]){
                            map[y][i] += map[cy][i];
                            map[cy][i] = 0;
                            y += dy[d];
                        }
                        else{
                            y += dy[d];
                            map[y][i] = map[cy][i];
                        }
                    }

                    cy += dy[d];
                }
                //y += dy[d];
                while(y < N && y >= 0){
                    map[y][i] = 0;
                    y += dy[d];
                }

            }//end for
        }//end_else
        
    }

    static void solve(int turn, int[][] map) throws InterruptedException{
        int temp = search_max(map);
        if(ans < temp) ans = temp;

        if(turn == 5) return;
        
        for(int i = 0 ; i < 4; i++){
            int[][] copyMap = MapCopy(map);
            move(copyMap, i);

            if(equal(map, copyMap)) continue;
            solve(turn+1, copyMap);
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map_ = new int[N][N];

        for(int i = 0  ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0  ; j < N; j++){
                map_[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, map_);

        System.out.println(ans);
    }
    static void print_map(int[][] map){
        for(int i = 0  ; i < N; i++){
            for(int j = 0  ; j < N; j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }
    }
}
