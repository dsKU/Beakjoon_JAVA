package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class beakjoon2252 {
    static int N, M;
    static int indegree[];
    static ArrayList<Integer>[] comp;
    static StringBuilder sb;
    
    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int idx = q.poll();
            sb.append(idx+" ");

            for(int i : comp[idx]){
                indegree[i] --;
                if(indegree[i] == 0)
                    q.offer(i);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comp = new ArrayList[N+1];
        indegree = new int[N+1];
        sb = new StringBuilder();

        for(int i = 1 ; i <= N; i++){
            comp[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            comp[a].add(b);
            indegree[b] ++;
        }

        topologicalSort();
        System.out.println(sb.toString());

    }
}
