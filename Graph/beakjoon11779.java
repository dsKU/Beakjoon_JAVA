import java.io.*;
import java.util.*;

public class beakjoon11779 {
    static int N,M, start, end;
    static int[][] map;
    static long[] min_;
    static int[] path;
    static long MAX_VAL = 1000000000000L;

    static void Dijkstra(int start){
        Arrays.fill(min_, MAX_VAL);
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        min_[start] = 0;
        pQ.offer(new Node(start,0));

        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            if(min_[node.a] < node.b) continue;

            for(int i =1; i <= N; i++){
                if(min_[i] > min_[node.a] + map[node.a][i]){
                    min_[i] = min_[node.a]+ map[node.a][i];
                    path[i] = node.a;   //이전 정점 업데이트 
                    pQ.offer(new Node(i, min_[i]));
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;//= new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        path = new int[N+1];
        min_ = new long[N+1];
        
        for(int i = 1 ; i <= N; i++)
            Arrays.fill(map[i], Integer.MAX_VALUE);

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[a][b] > c){  
                map[a][b] = c;
            } 
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        Dijkstra(start);

        System.out.println(min_[end]);

        Stack<Integer> s = new Stack<>();
        while(end != 0){    //스택에 도착점부터 이전 정점을 담아감
            s.add(end);
            end = path[end];
        }
        System.out.println(s.size());

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
}
class Node implements Comparable<Node>{
    int a;
    long b;
    Node(int a, long b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        if(this.b - o.b > 0) return 1;
        else return -1;
    }
}

/* test case
스페셜저지이기 때문에 답이 여러 개
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

answer = 
4
3
1 3 5 혹은 1 4 5
*/