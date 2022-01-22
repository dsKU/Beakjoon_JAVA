import java.io.*;
import java.util.*;

public class beakjoon2211 {
    static int N,M,K;
    static ArrayList<Node>[] list;
    static int[][] dist;
    static int[] min_;
    static int[] index;

    static void solve(){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        index[1] = 0;
        min_[1] = 0;
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.b > min_[node.a]) continue;
            for(int i =  1 ; i <= N; i++){
                if(min_[i] > node.b + dist[node.a][i]){
                    min_[i] = node.b + dist[node.a][i];
                    index[i] = node.a;
                    pq.add(new Node(i, min_[i]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];  
        min_  = new int[N+1];
        index = new int[N+1];

        for(int i = 1 ; i <= N; i++){
            Arrays.fill(dist[i], 10000000);
        }
        Arrays.fill(min_, 10000000);
        
        for(int i = 1 ; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(dist[a][b] > c){
                dist[a][b] = c; dist[b][a] =c;
            }
        } 

        solve();
        Stack<int[]> s = new Stack<>();
        int idx = N;
        while(idx != 1){
            int[] temp = {idx, index[idx]};
            s.add(temp);
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.size()).append("\n");
        while(!s.isEmpty()){
            int[] temp = s.pop();
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }
        System.out.println(sb);
    }
}
class Node implements Comparable<Node>{
    int a,b;
    public Node(int b, int c) {
        this.a = b;
        this.b = c;
    }
    @Override
    public int compareTo(Node o){
        return this.b - o.b;
    }
}
