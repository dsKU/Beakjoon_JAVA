package Graph;
import java.io.*;
import java.util.*;

public class beakjoon10026 {
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static int N;
    static int[][][] map;
    
    static char[][] RGB;

    static public void DFS(int y,int x, char ch, int cnt, int idx){
        map[idx][y][x] = cnt;

        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 && cx < N && cy >=0 && cy < N){
                if(RGB[cy][cx] == ch && map[idx][cy][cx] == 0){
                    DFS(cy,cx, ch, cnt, idx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        RGB = new char[N][N];
        map = new int[2][N][N];

        
        for(int i = 0 ; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < str.length(); j++){
                RGB[i][j] = str.charAt(j);
            }
        }
        int a = 1;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(map[0][i][j] == 0){
                    DFS(i,j,RGB[i][j], a, 0);
                    a++;
                }
            }
        }
        int b = 1;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(RGB[i][j] == 'G'){
                    RGB[i][j] = 'R';
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(map[1][i][j] == 0){
                    DFS(i,j,RGB[i][j], b, 1);
                    b++;
                }
            }
        }

        System.out.println((a-1) + " " + (b-1));
        sc.close();
    }
}
