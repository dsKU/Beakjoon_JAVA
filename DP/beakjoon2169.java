package DP;
import java.util.Arrays;
import java.util.Scanner;

public class beakjoon2169 {
    static int[] dx = {-1,1,0};
    static int[] dy = {0,0,-1};
    static int N;
    static int M;
    
    static public int DFS(int x, int y, int dir, int[][] map, int[][][] DP, boolean[][] visited){
        if( DP[x][y][dir] != -0 ) return DP[x][y][dir];

        DP[x][y][dir] = map[x][y];
        visited[x][y] = true;
        for(int i = 0; i < 3; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx > 0 && cx <= N && cy > 0 & cy <= M){
                if(visited[cx][cy]) continue;
                DP[x][y][dir] = Math.max(DP[x][y][dir], DFS(cx, cy, i, map, DP, visited) + map[x][y]);
            }
        }
        visited[x][y]= false;

        return DP[x][y][dir];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N+1][M+1];
        int[][][] DP = new int[N+1][M+1][3];
        boolean[][] visitred = new boolean[N+1][M+1];
        for(int i = 1; i <= N ; i++){
            Arrays.fill(visitred[i], false);
            for(int j = 1; j<= M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        
        int ans = Math.max(DFS(1, 1, 0 , map, DP, visitred),DFS(1, 1, 1 , map, DP, visitred));

        
        
        System.out.println(ans);
        sc.close();
    }
}

/*DP로 구현 예

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N+1][M+1];
        int[][] DP = new int[N+1][M+1];
        for(int i = 1; i <= N ; i++){
            //Arrays.fill(DP[i], -100001);
            for(int j = 1; j<= M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= M ; i++)
            DP[1][i] = DP[1][i-1] + map[1][i];

        for(int i = 2; i <= N ; i++){
            int[] R_DP = new int[M+1];
            int[] L_DP = new int[M+1];

            L_DP[1] = DP[i-1][1] + map[i][1];
            R_DP[M] = DP[i-1][M] + map[i][M];
            for(int j = 2; j <= M ; j++) L_DP[j] = Math.max(DP[i-1][j], L_DP[j-1] ) + map[i][j];
            for(int j = M-1; j >= 1 ; j--) R_DP[j] = Math.max(DP[i-1][j], R_DP[j+1] ) + map[i][j];
            for(int j = 1; j <= M ; j++) DP[i][j] = Math.max(L_DP[j], R_DP[j]);
        }
        System.out.println(DP[N][M]);
    }

*/