package Floyd;
import java.io.*;
import java.util.*;

public class beakjoon1956 {
    static int N,M;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        

        for(int i = 1 ; i <= N; i++){
            Arrays.fill(graph[i], 100_000_000);
            graph[i][i] = 0;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j])
                    graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
        int ans = 100_000_000;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                if(ans > graph[i][j] + graph[j][i])
                ans = graph[i][j] + graph[j][i];
            }
        }
        if(ans == 100_000_000) ans = -1;
        System.out.println(ans);

    }
}
