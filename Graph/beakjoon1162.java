import java.io.*;
import java.util.*;

public class beakjoon1162 {
    static int N,M,K;
    static ArrayList<Node1162>[] graph;
    static Long[][] dist;
    static Long INF = 1_000_000_000_000L;
    static void solve(){
        //Queue<Node1162> pq = new LinkedList<>();
        PriorityQueue<Node1162> pq = new PriorityQueue<>();
        pq.add(new Node1162(1, 0L, 0));
        dist[1][0] = 0L;

        while(!pq.isEmpty()){
            Node1162 node = pq.poll();
            int cnt = node.c;
            
            if(dist[node.a][cnt] < node.b)continue;

            for(Node1162 n : graph[node.a]){
                //포장 안 할 때
                if(dist[n.a][cnt] > node.b + n.b){
                    dist[n.a][cnt] = node.b + n.b;
                    pq.add(new Node1162(n.a, dist[n.a][cnt], cnt));
                }
                //포장 할 때
                if(cnt < K && dist[n.a][cnt+1] > node.b){
                    dist[n.a][cnt+1] = node.b;
                    pq.add(new Node1162(n.a, dist[n.a][cnt+1], cnt+1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    
        graph = new ArrayList[N+1];
        dist = new Long[N+1][21];
        for(int i = 1 ; i <= N; i ++){
            graph[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }
        for(int i = 1 ; i <= M; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node1162(b, c, 0));
            graph[b].add(new Node1162(a, c, 0));
        }
        
        solve();
        long ans = INF;
        for(int i = 0 ; i <= K; i++){
            ans = Math.min(ans, dist[N][i]);
        }
        System.out.println(ans);
    }
}
class Node1162 implements Comparable<Node1162>{
    int a;
    Long b;
    int c;
    public Node1162(int a, Long b, int c) {
        this.a = a; 
        this.b = b; 
        this.c = c;
    }
    @Override
    public int compareTo(Node1162 o){
        if(this.b - o.b > 0) return 1;
        return -1;
    }
}