package Graph;
import java.io.*;
import java.util.*;


public class beakjoon3055 {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int[] gaol = {0,0};
    static Queue<int[]> nextQue;
    static Queue<int[]> nextMove;
    public static void fill(){
        Queue<int[]> curQue = nextQue;
        nextQue = new LinkedList<>();

        while(!curQue.isEmpty()){
            int[] node = curQue.poll();

            for(int i = 0 ; i < 4;i++){
                int cx = node[1] + dx[i];
                int cy = node[0] + dy[i];  
                if(cx < 0 || cx >= M || cy < 0 || cy >= N) continue;
                if(map[cy][cx] == '.' ){
                    nextQue.add(new int[]{ cy,cx });
                    map[cy][cx] = 'W';
                }
            }
        }
    }
    static public boolean moveBfs(){
        Queue<int[]> move = nextMove;
        nextMove = new LinkedList<>();
        
        while(!move.isEmpty()){
            int[] node = move.poll();

            for(int i = 0 ; i < 4;i++){
                int cx = node[1] + dx[i];
                int cy = node[0] + dy[i];  
                if(cx < 0 || cx >= M || cy < 0 || cy >= N) continue;
                if(cy == gaol[0] && cx == gaol[1]) return true;

                if( map[cy][cx] == '.' && !visited[cy][cx]){
                    nextMove.add(new int[]{cy,cx});
                    visited[cy][cx] = true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        nextQue = new LinkedList<>();
        nextMove = new LinkedList<>();
        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '*'){
                    nextQue.add(new int[]{i,j});
                    map[i][j] = 'W';
                }
                else if(map[i][j] == 'S'){
                    map[i][j] = '.';
                    nextMove.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                else if(map[i][j] == 'D'){
                    gaol[0] = i;
                    gaol[1] = j;
                }
            }
        }

        int ans = 0;
        while(true){
            ans++;
            fill();
            if(moveBfs()) break;
            if(nextMove.isEmpty()){
                ans = -1;
                break;
            }
            // for(int i = 0 ; i < N; i++){
            //     for(int j= 0 ; j < M; j++){
            //         System.out.print(map[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

        }
        if(ans == -1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(ans);
        }

    }
}
