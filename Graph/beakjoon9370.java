package Graph;
import java.io.*;
import java.util.*;

public class beakjoon9370 {
    static int N,M,K;
    static int s,g,h;
    static int[][] graph;
    static int[] dist_s;
    static int[] dist_g;
    static int[] dist_h;
    static void solve(int start, int[] dist){
        PriorityQueue<Node9370> pq = new PriorityQueue<>();
        pq.add(new Node9370(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node9370 Node9370 = pq.poll();

            if(dist[Node9370.a] < Node9370.b) continue;
            for(int i = 1; i <= N; i++){
                if(dist[i] > Node9370.b + graph[Node9370.a][i]){
                    dist[i] = Node9370.b + graph[Node9370.a][i];
                    pq.add(new Node9370(i, dist[i]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;//= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        graph = new int[2001][2001];
        dist_s = new int[2001]; 
        dist_g = new int[2001];
        dist_h = new int[2001];
    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++){
                Arrays.fill(graph[i], 10_0000_0000); 
                Arrays.fill(dist_s, 10_0000_0000); 
                Arrays.fill(dist_h, 10_0000_0000); 
                Arrays.fill(dist_g, 10_0000_0000); 
            }            

            for(int i = 1; i <= M; i++){
                st = new StringTokenizer(br.readLine());
                int a  = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a][b] = c; graph[b][a] = c;
            }
            solve(s, dist_s);
            solve(g, dist_g);
            solve(h, dist_h);

            for(int i = 0 ; i < K; i++){
                int temp = Integer.parseInt(br.readLine());
                if(dist_s[g] + graph[g][h] + dist_h[temp] == dist_s[temp] ||
                dist_s[h] + graph[h][g] + dist_g[temp] == dist_s[temp]) pq.add(temp);
            }
            
            while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}

class Node9370 implements Comparable<Node9370>{
    int a;
    int b;
    Node9370(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node9370 o) {
        return this.b - o.b;
    }
}