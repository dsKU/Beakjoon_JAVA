package Floyd;
import java.io.*;
import java.util.*;

public class beakjoon11404 {
    static int N,M;
    static int[][] graph;
    static int[][] floyd;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        floyd = new int[N+1][N+1];

        for(int i = 1 ; i <= N; i++){
            Arrays.fill(graph[i], 100_000_000);
            graph[i][i] = 0;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(graph[a][b] <= c) continue;
            graph[a][b] = c;
        }
        
        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                floyd[i][j] = graph[i][j];                   
            }
        }  

        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                for(int k = 1 ; k <= N; k++){
                    if(floyd[j][k] > floyd[j][i] + floyd[i][k])
                        floyd[j][k] = floyd[j][i] + floyd[i][k];   
                }
            }
        }    

        for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                if(floyd[i][j] >= 100_000_000) floyd[i][j] = 0;
                System.out.print(floyd[i][j] + " ");         
            }
            System.out.println();
        } 

    }

}
