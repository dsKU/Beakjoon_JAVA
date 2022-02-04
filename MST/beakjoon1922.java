package MST;
import java.io.*;
import java.util.*;

public class beakjoon1922 {
    static int N,M;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(graph[a][b] == 0){
                graph[a][b] = c;
                graph[b][a] = c;
            }
            else{
                if(graph[a][b] > c){
                    graph[a][b] = c;
                    graph[b][a] = c;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.add(new int[]{1,0});
        int ans = 0;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(visited[node[0]]) continue;
            
            visited[node[0]] = true;
            ans += node[1];

            for(int i = 1 ; i <= N; i++){
                if(visited[i] || graph[node[0]][i] == 0) continue;

                pq.add(new int[]{i, graph[node[0]][i]});
            }

        }
        System.out.println(ans);


    }
}
