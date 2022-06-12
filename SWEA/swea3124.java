import java.io.*;
import java.util.*;
public class swea3124 {
    static ArrayList<node>[] graph;
    static boolean[] visited = new boolean[100001];

    static int[] parents = new int[100_001];
    static edge[] edges;
    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    static boolean union(int a, int b){
        int aR = find(a);
        int bR = find(b);

        if(aR == bR) return false;

        parents[bR] = aR;
        return true;

    }
    static long kuruskal(){
        Arrays.sort(edges, (a,b)->a.weight - b.weight);
        int ans = 0;

        for(edge e : edges){
            if(union(e.from, e.to)){
                ans += e.weight;
            }
        }
        return ans;
    }
    static long prim(){
        int ans = 0;

        PriorityQueue<node> pq = new PriorityQueue<>((a,b)->a.b-b.b); 
        pq.add(new node(1,0));
        while(!pq.isEmpty()){
            node n = pq.poll();
            
            if(visited[n.a])continue;
            visited[n.a] = true;
            ans += n.b;

            for(node to : graph[n.a]){
                if(visited[to.a])continue;
                pq.add(to);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        graph = new ArrayList[100001];
        
        for(int i = 1; i < 100001; i++) graph[i] = new ArrayList<>();

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i =1; i <= N; i++){
                graph[i].clear();
                visited[i] = false;
                parents[i] = i;
            }
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new node(b,c));
                graph[b].add(new node(a,c));
                edges[i] = new edge(a,b,c);
            }
            long ans = kuruskal(); // prim();

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
    
}
class edge{
    int from,to,weight;
    public edge(int a, int b, int c){
        from = a;
        to = b;
        weight = c;
    }
}
class node{
    int a, b;
    public node(int a, int b){
        this.a = a;
        this.b = b;
    }
}