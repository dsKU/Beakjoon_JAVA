package Floyd;
import java.io.*;
import java.util.*;

public class beakjoon1613 {
    static int N,M, K;
    static int[][] graph;
    static int INF = 100_000_000;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i = 1 ; i <= N; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = 0;
            if(graph[a][b] == INF && graph[b][a] == INF ) temp = 0;
            else if(graph[a][b] != INF) temp = -1;
            else if(graph[b][a] != INF) temp = 1; 
            sb.append(temp).append("\n");
        }
        System.out.print(sb);
    }
}
