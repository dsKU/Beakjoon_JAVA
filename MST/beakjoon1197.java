package MST;
import java.io.*;
import java.util.*;
//prim MST
public class beakjoon1197 {
    static int N,M;
    static ArrayList<Node1197>[] graph;
    static boolean[] visited;

    static int solve(){
        int ret = 0;
        PriorityQueue<Node1197> pq = new PriorityQueue<>();
        pq.add(new Node1197(1,0));
        
        while(!pq.isEmpty()){
            Node1197 node = pq.poll();
            if(visited[node.to]) continue;
            visited[node.to] = true;
            ret += node.val;

            for(Node1197 n : graph[node.to]){
                if(visited[n.to]) continue;
                pq.add(n);
            }

        }


        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(visited, false);

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node1197(b, c));
            graph[b].add(new Node1197(a, c));
        }
        System.out.println(solve());

    }
}
class Node1197 implements Comparable<Node1197>{
    int to;
    int val;

    public Node1197(int a, int b){
        this.to = a;
        this.val = b;
    }

    @Override
    public int compareTo(Node1197 o) {
        return this.val - o.val;
    }

}