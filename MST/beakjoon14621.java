package MST;
import java.io.*;
import java.util.*;
//prim MST
public class beakjoon14621 {
    static int N,M;
    static ArrayList<Node14621>[] graph;
    static boolean[] visited;
    static boolean[] univ;

    static int solve(){
        int ret = 0;
        PriorityQueue<Node14621> pq = new PriorityQueue<>();
        pq.add(new Node14621(1,0));
        
        while(!pq.isEmpty()){
            Node14621 node = pq.poll();
            if(visited[node.to]) continue;
            visited[node.to] = true;
            ret += node.val;

            for(Node14621 n : graph[node.to]){
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
        univ = new boolean[N+1];    //남초 true 여초 fasle
        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(visited, false);

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            if(st.nextToken().charAt(0) == 'M') univ[i] = true;
            else univ[i] = false;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(univ[a] == univ[b]) continue;
            graph[a].add(new Node14621(b, c));
            graph[b].add(new Node14621(a, c));
        }
        int ret = solve();
        for(int i = 1; i <= N;i++){
            if(!visited[i]){
                ret = -1;
                break;
            }
        }
        System.out.println(ret);
    }
}
class Node14621 implements Comparable<Node14621>{
    int to;
    int val;

    public Node14621(int a, int b){
        this.to = a;
        this.val = b;
    }

    @Override
    public int compareTo(Node14621 o) {
        return this.val - o.val;
    }

}