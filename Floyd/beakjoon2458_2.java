package Floyd;
import java.io.*;
import java.util.*;

/*
중복을 허용하지 않는 이동 경로??의 개수

*/
public class beakjoon2458_2 {
    static int N,M;
    static int[][] graph;
    static int[][] floyd;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        floyd = new int[N+1][N+1];
        
        for(int i = 1 ; i <= N; i++)
            Arrays.fill(floyd[i], 100_000_000);
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            floyd[a][b] = 1;
        }
        
        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                for(int k = 1 ; k <= N; k++){
                    if(floyd[j][k] > floyd[j][i] + floyd[i][k])
                    floyd[j][k] = floyd[j][i] + floyd[i][k];
                }
            }
        }  

        int[] cnt = new int[N+1];
        int ans = 0;
        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                if(floyd[i][j] == 100_000_000) continue;
                cnt[i]++;   cnt[j]++;
                if(cnt[i] == N-1) ans++;
                if(cnt[j] == N-1) ans++;
            }
        }    
        System.out.println(ans);
        /*
        
        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                if(floyd[i][j] == 100_000_000) floyd[i][j] = 0;
                System.out.printf("%3d ",floyd[i][j]);         
            }
            System.out.println();
        } 
        */
    }
}
