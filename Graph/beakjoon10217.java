import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int to;
    int time;
    int cost;
    public Node(int a, int b, int c) {
        this.to = a;
        this.time = b;
        this.cost = c;
    }
    @Override
    public int compareTo(Node o){
        return this.time - o.time;
    }
}


public class beakjoon10217 {
    static int N,C,K;
    static int s,g,h;
    static ArrayList<Node>[] graph;
    static int[][] cost;
    static void solve(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));

        cost[1][0] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(cost[node.to][node.cost] < node.time) continue;

            for(Node n : graph[node.to]){
                int cost_ = node.cost + n.cost;
                if(cost_ > C) continue;
                if(cost[n.to][cost_] > n.time + node.time){
                    cost[n.to][cost_] = n.time + node.time;
                    pq.add(new Node(n.to, cost[n.to][cost_], cost_));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;//= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        cost = new int[102][10002];
        graph = new ArrayList[102];

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++){
                Arrays.fill(cost[i], 987654321);
                graph[i] = new ArrayList<>();
            }

            for(int i = 1; i <= K; i++){
                st = new StringTokenizer(br.readLine());
                int a  = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, d, c));
            }

            solve();
            int ans = 987654321;
            for(int i= 0  ; i <= C; i++)
                ans = Math.min(ans, cost[N][i]);
            
            if(ans >= 987654321) sb.append("Poor KCM\n");
            else sb.append(ans).append("\n");

        }
        System.out.print(sb);
    }
}

