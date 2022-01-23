package Graph;
import java.io.*;
import java.util.*;

class Node10217 implements Comparable<Node10217>{
    int to;
    int time;
    int cost;
    public Node10217(int a, int b, int c) {
        this.to = a;
        this.time = b;
        this.cost = c;
    }
    @Override
    public int compareTo(Node10217 o){
        return this.time - o.time;
    }
}


public class beakjoon10217 {
    static int N,C,K;
    static int s,g,h;
    static ArrayList<Node10217>[] graph;
    static int[][] cost;
    static void solve(){
        PriorityQueue<Node10217> pq = new PriorityQueue<>();
        pq.add(new Node10217(1, 0, 0));

        cost[1][0] = 0;

        while(!pq.isEmpty()){
            Node10217 Node10217 = pq.poll();

            if(cost[Node10217.to][Node10217.cost] < Node10217.time) continue;

            for(Node10217 n : graph[Node10217.to]){
                int cost_ = Node10217.cost + n.cost;
                if(cost_ > C) continue;
                if(cost[n.to][cost_] > n.time + Node10217.time){
                    cost[n.to][cost_] = n.time + Node10217.time;
                    pq.add(new Node10217(n.to, cost[n.to][cost_], cost_));
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
                graph[a].add(new Node10217(b, d, c));
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

