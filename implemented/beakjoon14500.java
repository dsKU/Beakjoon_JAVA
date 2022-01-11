package implemented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class beakjoon14500 {
    //DFS로도 구현 가능
    //3차원 배열로 도형 구현 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int ans = 0;
        
        for(int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0 ; i < N; i ++){   //  ㅡ
            int figure = map[i][0] + map[i][1] + map[i][2];
            for(int j = 3 ; j <M ; j ++){
                figure += map[i][j];
                ans = Math.max(ans, figure);
                figure -= map[i][j-3];
            }
        }
        
        for(int i = 0 ; i < M; i ++){   // ㅣ
            int figure = map[0][i] + map[1][i] + map[2][i];
            for(int j = 3 ; j < N ; j ++){
                figure += map[j][i];
                ans = Math.max(ans, figure);
                figure -= map[j-3][i];
            }
        }

        for(int i = 1 ; i < N; i ++){   // ㅁ
            for(int j = 1 ; j < M ; j ++){
                int figure = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i - 1][j - 1];
                ans = Math.max(ans, figure);
            }
        }

        for(int i = 1 ; i < N; i ++){   // 2*3
            for(int j = 2 ; j < M ; j ++){
                int rect = map[i][j] +map[i][j - 1] +map[i][j-2] +map[i - 1][j] +map[i - 1][j - 1] +map[i - 1][j-2];
                int figure1 = rect - map[i - 1][j] - map[i][j - 2]; //Z
                int figure2 = rect - map[i][j] - map[i - 1][j - 2]; //Z 뒤집
                int figure3 = rect - map[i - 1][j] - map[i - 1][j - 2]; // ㅗ
                int figure4 = rect - map[i][j] - map[i][j - 2]; // ㅜ
                int figure5 = rect - map[i][j - 1] - map[i][j - 2]; // ㄱ
                int figure6 = rect - map[i][j] - map[i][j - 1]; // ㄱ뒤집
                int figure7 = rect - map[i - 1][j - 1] - map[i - 1][j - 2]; // ㄴ
                int figure8 = rect - map[i - 1][j] - map[i - 1][j - 1]; // ㄴ뒤집
                int temp1 = Math.max(Math.max(figure1, figure2), Math.max(figure3, figure4));
                int temp2 = Math.max(Math.max(figure5, figure6), Math.max(figure7, figure8));
                ans = Math.max(ans, Math.max(temp1, temp2));
            }
        }
        for(int i = 2 ; i < N; i ++){   // 3*2
            for(int j = 1 ; j < M ; j ++){
                int rect = map[i][j] +map[i][j - 1] +map[i - 1][j] +map[i - 1][j - 1] +map[i - 2][j - 1] +map[i - 2][j];
                int figure1 = rect - map[i - 2][j] - map[i][j - 1]; // 
                int figure2 = rect - map[i][j] - map[i - 2][j - 1]; // 
                int figure3 = rect - map[i - 2][j] - map[i][j]; // ㅏ
                int figure4 = rect - map[i][j - 1] - map[i - 2][j - 1]; // ㅓ
                int figure5 = rect - map[i][j - 1] - map[i - 1][j - 1]; // ㄱ
                int figure6 = rect - map[i][j] - map[i - 1][j]; // ㄱ뒤집
                int figure7 = rect - map[i - 1][j] - map[i - 2][j]; // ㄴ
                int figure8 = rect - map[i - 1][j - 1] - map[i - 2][j - 1]; // ㄴ뒤집
                
                int temp1 = Math.max(Math.max(figure1, figure2), Math.max(figure3, figure4));
                int temp2 = Math.max(Math.max(figure5, figure6), Math.max(figure7, figure8));
                ans = Math.max(ans, Math.max(temp1, temp2));
            }
        }
        System.out.println(ans);
    }
}
