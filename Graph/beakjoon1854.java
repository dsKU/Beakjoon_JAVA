package Graph;
import java.io.*;
import java.util.*;


public class beakjoon1854 {
    static int N,M,K;
    static ArrayList<Node1854>[] graph;
    static PriorityQueue<Integer>[] dist;

    static void solve(){
        PriorityQueue<Node1854> pq= new PriorityQueue<>();
        pq.add(new Node1854(1, 0));
        
        while(!pq.isEmpty()){
            Node1854 Node1854 = pq.poll();

            if(dist[Node1854.a].size() == K) continue;

            dist[Node1854.a].add(Node1854.b);

            for(Node1854 n : graph[Node1854.a]){
                if(dist[n.a].size() == K) continue;

                pq.add(new Node1854(n.a, n.b + Node1854.b));
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dist = new PriorityQueue[N+1];
        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node1854(b,c));
        }

        solve();
        for(int i = 1; i <= N; i++){
            
            if(dist[i].size() != K) System.out.println(-1);
            else System.out.println(dist[i].poll());
        }


    }
}

class Node1854 implements Comparable<Node1854>{
    int a,b;
    public Node1854(int b, int c) {
        this.a = b;
        this.b = c;
    }
    @Override
    public int compareTo(Node1854 o){
        return this.b - o.b;
    }
}
