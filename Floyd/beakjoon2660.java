package Floyd;
import java.io.*;
import java.util.*;

public class beakjoon2660 {
    static int N,M;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i = 1 ; i <= N; i++){
            Arrays.fill(graph[i], 100_000_000);
            graph[i][i] = 0;
        }
            

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(graph[k][j] + graph[i][k] < graph[i][j])
                    graph[i][j] = graph[k][j] + graph[i][k];
                }
            }
        }
        int[] friend = new int[N+1];
        int min_ = 51;
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                friend[i] = Math.max(friend[i], graph[i][j]);
            }
            if(min_ > friend[i]){
                cnt = 1;
                min_ = friend[i];
            }
            else if(min_ == friend[i]){
                cnt++;
            }
        }
        System.out.println(min_ + " " + cnt);
        for(int i = 1; i <= N; i++){
            if(friend[i] == min_) System.out.print(i +" ");
        }

    }
}
