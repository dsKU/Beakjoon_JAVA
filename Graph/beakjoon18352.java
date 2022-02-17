package Graph;
import java.io.*;
import java.util.*;

public class beakjoon18352 {
    static int N, M, K, S;
    static ArrayList<Integer>[] graph;
    static int[] dis;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dis = new int[N+1];
        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
            dis[i] = 300001;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        ArrayList<Integer> ans = new ArrayList<>();
        dis[S] = 0;
        pq.add(new int[]{S,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int index = node[0];
            if(node[1] > K) break;
            if(dis[index] == K){
                ans.add(index);
            }

            for(int i : graph[index]){
                if(dis[i] > dis[index] + 1){
                    dis[i] = dis[index] + 1;
                    pq.add(new int[]{i, dis[i]});
                }
            }
        }
        if(ans.size() == 0)System.out.println(-1);
        else{
            ans.sort((a,b)->a-b);
            for(int i : ans){
                System.out.println(i);
            }
        }
        
    }
}
