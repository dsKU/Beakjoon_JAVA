import java.io.*;
import java.util.*;

public class beakjoon10282 {
    static int T, N, D, C;
    static ArrayList<Node>[] list;
    static int[] min_;
    static void Dijkstra(int start){
        min_[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.b > min_[node.a]) continue;

            for(Node n : list[node.a]){
                 if(min_[n.a] > node.b + n.b ){
                     min_[n.a] = node.b + n.b;
                     pq.add(new Node(n.a, min_[n.a]));
                 }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            min_ = new int[N+1];
            for(int i = 1  ; i <= N; i++){
                list[i] = new ArrayList<>();
                min_[i] = 100000000;
            }
            for(int i = 0 ; i < D; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a,c)); //의존성이라 두 개 바뀌어야 함
            }
            Dijkstra(C);
            int cnt = 0;
            int time = 0;
            for(int i = 1 ; i <= N; i++){
                if(min_[i] < 10000000){
                    cnt++;
                    time = Math.max(min_[i], time);
                }
            }
            System.out.println(cnt + " " + time);
        }

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
