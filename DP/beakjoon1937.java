package DP;
import java.util.Scanner;


public class beakjoon1937 {
    static int[] dx = {-1, 0 , 1 ,0};
    static int[] dy = {0, 1, 0 , -1};
    static int[][] map = new int[502][502];
    static int[][] DP = new int[502][502];
    static int N ;

    static int DFS(int x, int y){
        if(DP[x][y] != 0) return DP[x][y];


        DP[x][y] = 1;
        for(int i = 0;i < 4 ; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx < 0 || cx > N || cy < 0 || cy > N)
                continue;

            if(map[x][y] < map[cx][cy]){
                DP[x][y] = Math.max(DFS(cx,cy) + 1, DP[x][y]);
            }
        }
        
        return DP[x][y];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int ans = 0;
        for(int i =1 ;i <= N;i++){
            for(int j =1 ;j <= N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i =1 ;i <= N;i++){
            for(int j =1 ;j <= N;j++){
                ans = Math.max(ans, DFS(i,j));
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
