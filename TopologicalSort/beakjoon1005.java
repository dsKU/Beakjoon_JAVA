package TopologicalSort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beakjoon1005 {

    static void topological_sort(int[] indegree, ArrayList<ArrayList<Integer>> arr, int N, int[] val, int W){
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[N+1];
 
        for(int i=1; i<=N; i++) {
            result[i] = val[i];
 
            if(indegree[i] == 0)
                q.offer(i);
        }
 
        while(!q.isEmpty()) {
            int node = q.poll();
 
            for(Integer i : arr.get(node)) {
                result[i] = Math.max(result[i], result[node] + val[i]);
                indegree[i]--;
 
                if(indegree[i] == 0)
                    q.offer(i);
            }
        }
 
        System.out.println(result[W]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] val = new int[N+1];
            ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
            int[] indegree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i <= N; i++){
                arr.add(new ArrayList<Integer>());
            }

            for(int i = 1; i <= N; i++){
                val[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr.get(from).add(to);
                indegree[to]++;
            }
            int W = Integer.parseInt(br.readLine());
            topological_sort(indegree,arr,N,val,W);
        }
		br.close();
    }
}
