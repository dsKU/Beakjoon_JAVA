package Graph;
import java.io.*;
import java.util.*;


public class beakjoon1260 {
    static int N,M;
    static int[]arr;
    static boolean[] visited;
    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();
    static void DFS(int idx){
        visited[idx] = true;
        sb.append(idx).append(" ");

        for(int i = 1; i <= N; i++){
            if(graph[idx][i] && !visited[i]) DFS(i);
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        
        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }


        DFS(R);
        sb.append("\n");

        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(R);

        while(!q.isEmpty()){
            int idx = q.poll();
            if(visited[idx])continue;

            visited[idx] = true;
            sb.append(idx).append(" ");

            for(int i = 1; i <= N; i++){
                if(graph[idx][i] && !visited[i]) q.add(i);
                
            }
        }
        System.out.print(sb);
    }
}
