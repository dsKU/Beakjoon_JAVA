package Graph;
import java.io.*;
import java.util.*;

public class beakjoon1185 {
    static int N,M;
    static int[] city;
    static boolean[] visited;
    static ArrayList<Node1328>[] graph;
    static long solve(){
        long ret = 0;
        PriorityQueue<Node1328> pq = new PriorityQueue<>();
        
        pq.add(new Node1328(1, 0));
        
        while(!pq.isEmpty()){
            Node1328 node = pq.poll();

            if(visited[node.to]) continue;

            visited[node.to] = true;
            ret += node.weight;

            for(Node1328 n: graph[node.to]){
                if(!visited[n.to]){
                    pq.add(n);
                }
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

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        city = new int[N+1];
        int min_ = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            city[i] = Integer.parseInt(br.readLine());
            min_ = Math.min(city[i], min_);

            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            c = c + c + city[b] + city[a];
            graph[a].add(new Node1328(b, c ));
            graph[b].add(new Node1328(a, c ));
        }
        long ans = solve() + min_;

        System.out.println(ans);
    }
}

class Node1328 implements Comparable<Node1328>{
    int to;
    int weight;

    public Node1328(int b,int c){
        to = b;
        weight = c;
    }
    @Override
    public int compareTo(Node1328 o){
        return this.weight - o.weight;
    }

}

