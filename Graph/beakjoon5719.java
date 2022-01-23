import java.io.*;
import java.util.*;

public class beakjoon5719 {
    static int N,M;
    static int s,e;
    static Boolean[][] shortest;
    static ArrayList<Node5719>[] graph;
    static ArrayList<Integer>[] visited;
    static int[] dist;
    static int INF = 1_000_000_000;
    
    static void remove(){
        Arrays.fill(dist, INF);
        PriorityQueue<Node5719> pq = new PriorityQueue<>();
        pq.add(new Node5719(s, 0));

        dist[s] = 0;

        while(!pq.isEmpty()){
            Node5719 node = pq.poll();
            if(node.b > dist[node.a])continue;

            for(Node5719 n : graph[node.a]){
                if(node.b + n.b == dist[n.a]) visited[n.a].add(node.a);
                else if(node.b + n.b < dist[n.a]){
                    dist[n.a] = node.b + n.b;
                    visited[n.a].clear();
                    visited[n.a].add(node.a);
                    pq.add(new Node5719(n.a, dist[n.a]));
                }
            }

        }
    }
    static void remove(int from, int to){
        if(from == to) return;

        for(int i : visited[to]){
            if(!shortest[i][to]){
                shortest[i][to] = true;
                remove(from,i);
            }
        }

    }

    static void solve(){
        Arrays.fill(dist, INF);
        PriorityQueue<Node5719> pq = new PriorityQueue<>();
        pq.add(new Node5719(s, 0));

        dist[s] = 0;

        while(!pq.isEmpty()){
            Node5719 node = pq.poll();
            if(node.b > dist[node.a])continue;

            for(Node5719 n : graph[node.a]){
                if(shortest[node.a][n.a]) continue;
                if(node.b + n.b < dist[n.a]){
                    dist[n.a] = node.b + n.b;
                    pq.add(new Node5719(n.a, dist[n.a]));
                }
            }

        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        shortest = new Boolean[502][502];
        graph = new ArrayList[502];
        dist = new int[502];
        visited = new ArrayList[502];

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
        
            
            for(int i = 0 ; i < N; i++){
                Arrays.fill(shortest[i], false);
                graph[i] = new ArrayList<>();
                visited[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            for(int i = 0 ; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                graph[a].add(new Node5719(b, c));    
            }

            remove();
            remove(s,e);
            solve();

            if(dist[e] == INF)sb.append(-1).append("\n");
            else sb.append(dist[e]).append("\n");

        }
        System.out.print(sb);
    }
}

class Node5719 implements Comparable<Node5719>{
    int a;
    int b;
    public Node5719(int a, int b) {
        this.a = a; // x
        this.b = b; // y
    }
    @Override
    public int compareTo(Node5719 o){
        if(this.b - o.b > 0) return 1;
        return -1;
    }
}