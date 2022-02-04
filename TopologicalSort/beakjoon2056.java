package TopologicalSort;
import java.io.*;
import java.util.*;

public class beakjoon2056 {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static int[] time;
    static int[] DP;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static void topologicalSort(){
        while(!pq.isEmpty()){
            int idx = pq.poll();

            for(int i : graph[idx]){
                indegree[i]--;
                DP[i] = Math.max(DP[i], DP[idx] + time[i]);

                if(indegree[i] == 0){
                    pq.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        time = new int[N+1];
        DP = new int[N+1];

        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            DP[i] = time[i];

            int t = Integer.parseInt(st.nextToken());
            if(t == 0) pq.add(i);
            while(t-- > 0){
                graph[Integer.parseInt(st.nextToken())].add(i);
                indegree[i]++;
            }
        }

        topologicalSort();
        int ans = 0;
        for(int i = 1 ; i <= N; i++){
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(ans);
    }
}
