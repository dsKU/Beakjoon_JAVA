package BackTracking;
import java.util.Scanner;

public class beakjoon1987 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] st;
    static int ans;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    static void DFS(int x, int y, int cnt){
        if(st[map[x][y]]){
            ans = Math.max(ans, cnt);
            return;
        }
        st[map[x][y]] = true;
        for(int i =0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cy >= 0 && cx < N && cy < M){
                DFS(cx,cy, cnt+1);
            }
            
        }
        
        st[map[x][y]] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        st = new boolean[26];
        N = sc.nextInt();
        M = sc.nextInt();
        ans = 1;
        sc.nextLine();
        map = new int[N+1][M+1];
        for(int i = 0 ; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - 'A';
            }
        }
            
        
        DFS(0,0,0);
        System.out.println(ans);
        sc.close();
    }
}
