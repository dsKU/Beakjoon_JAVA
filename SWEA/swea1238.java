import java.io.*;
import java.util.*;

public class swea1238 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] visited = new int[101];
        ArrayList<Integer>[] graph = new ArrayList[101];
        for(int i = 1; i < 101; i++) graph[i] = new ArrayList<>();

        int t = 1;
        while(br.ready()){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            
            for(int i = 1; i < 101; i++) {
                graph[i].clear();
                visited[i] = 0;
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N/2; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
            }

            Queue<Integer> que = new LinkedList<>();
            que.add(R);
            visited[R] = 1;
            int level = 0;

            while(!que.isEmpty()){
                int idx = que.poll();
                
                for(int i : graph[idx]){
                    if(visited[i] != 0) continue;
                    que.add(i);
                    visited[i] = visited[idx] + 1;
                    if(level < visited[i]) level = visited[i];
                }
            }

            int ans = 0;
            for(int i = 100; i >= 1; i--){
                if(level == visited[i]){
                    ans = i; break;
                }
            }
            
            sb.append("#").append(t++).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
