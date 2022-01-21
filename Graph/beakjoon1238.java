import java.io.*;
import java.util.*;

public class beakjoon1238 {
    static int N,M, K;
    static ArrayList<Node>[] map;
    static ArrayList<Node>[] map2;
    static int[] min_;
    static int[] min_2;
    static int MAX_VAL = 10000000;

    static void Dijkstra1(int start){
        Arrays.fill(min_, MAX_VAL);
        min_[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(min_[node.a] < node.b) continue;
            for(Node n : map[node.a]){
                if(min_[n.a] > min_[node.a]+n.b){
                    min_[n.a] = min_[node.a]+n.b;
                    pq.offer(new Node(n.a, min_[n.a]));
                }
            }
        }
    }

    static void Dijkstra2(int start){
        Arrays.fill(min_2, MAX_VAL);
        min_2[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(min_2[node.a] < node.b) continue;
            for(Node n : map2[node.a]){
                if(min_2[n.a] > min_2[node.a]+n.b){
                    min_2[n.a] = min_2[node.a]+n.b;
                    pq.offer(new Node(n.a, min_2[n.a]));
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
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        min_ = new int[N+1];
        map2 = new ArrayList[N+1];
        min_2 = new int[N+1];
        for(int i = 1 ; i <= N; i++){
            map[i] = new ArrayList<>();
            map2[i] = new ArrayList<>();
        }
            
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b,c));
            map2[b].add(new Node(a,c)); // 간선을 역으로 줘서 저장
        }
        Dijkstra1(K);   // K 에서 집으로 돌아가는 거리들
        Dijkstra2(K);   // k로 가는 거리들
        int ans = 0;
        for(int i = 1 ; i <= N; i++){
            ans = Math.max(ans, min_[i] + min_2[i]);
        }

        System.out.println(ans);
    }
}

class Node implements Comparable<Node>{
    int a;
    int b;
    Node(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        return this.b - o.b;
    }
}

/*test case

4 9 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
2 1 100

answer = 10


*/